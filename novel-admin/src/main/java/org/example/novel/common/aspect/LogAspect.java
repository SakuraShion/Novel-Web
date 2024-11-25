package org.example.novel.common.aspect;

import groovy.util.logging.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.example.novel.common.domain.SysLog;
import org.example.novel.common.service.SysLogService;
import org.example.novel.common.utils.HttpContextUtils;
import org.example.novel.common.utils.IPUtils;
import org.example.novel.common.utils.JSONUtils;
import org.example.novel.common.utils.ShiroUtils;
import org.example.novel.system.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Author：hb
 * @Package：org.example.novel.common.aspect
 * @Project：my
 * @Date：21/11/2024 4:30 pm
 */
@Aspect
@Component
public class LogAspect {
    @Autowired
    private SysLogService logService;

    @Pointcut("@annotation(org.example.novel.common.annotation.Log)")
    public void logPointCut(){
    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point)throws Throwable{
        long beginTime = System.currentTimeMillis();
        Object result = point.proceed();
        long endTime = System.currentTimeMillis();
        saveLog(point,endTime-beginTime);
        return result;

    }

    public void saveLog(ProceedingJoinPoint point,long time){
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        SysLog sysLog=new SysLog();
        SysUser user = ShiroUtils.getUser();
        Log annotation = method.getAnnotation(Log.class);
        if (annotation!=null){
            sysLog.setOperation(annotation.value());
        }
        String className = point.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setMethod(className+"."+methodName);
        Object[] args = point.getArgs();
        String params = JSONUtils.beanToJson(args).substring(0,4999);
        sysLog.setParams(params);
        // 获取request
        HttpServletRequest httpServletRequest = HttpContextUtils.getHttpServletRequest();
        sysLog.setIp(IPUtils.getIpAddr(httpServletRequest));
        if (user==null){
            sysLog.setId(-1L);
            sysLog.setUsername(sysLog.getParams());
        }else {
            sysLog.setId(user.getUserId());
            sysLog.setUsername(sysLog.getUsername());
        }
        sysLog.setTime((int)time);
        Date date=new Date();
        sysLog.setGmtCreate(date);
        logService.save(sysLog);
    }
}
