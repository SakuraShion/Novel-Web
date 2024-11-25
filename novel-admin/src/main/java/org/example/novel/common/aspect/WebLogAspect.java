package org.example.novel.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Author：hb
 * @Package：org.example.novel.common.aspect
 * @Project：my
 * @Date：22/11/2024 8:55 am
 */
@Aspect
@Component
public class WebLogAspect {
    private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    @Pointcut("execution( * org.example..controller.*.*(..))")//两个..代表所有子目录，最后括号里的两个..代表所有参数
    public void logPointCut() {
    }
    @Before("logPointCut()")
    public void deBefore(JoinPoint joinPoint){
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        logger.info("请求地址 : " + request.getRequestURL().toString());
        logger.info("HTTP METHOD : " + request.getMethod());
        // 获取真实的ip地址
        //logger.info("IP : " + IPAddressUtil.getClientIpAddress(request));
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName());
        logger.info("参数 : " + Arrays.toString(joinPoint.getArgs()));
//        loggger.info("参数 : " + joinPoint.getArgs());
    }
    @AfterReturning(returning = "ret", pointcut = "logPointCut()")// returning的值和doAfterReturning的参数名一致
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容(返回值太复杂时，打印的是物理存储空间的地址)
        logger.debug("返回值 : " + ret);
    }

    @Around("logPointCut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long l = System.currentTimeMillis();
        Object proceed = pjp.proceed();
        logger.info("耗时 : " + (System.currentTimeMillis() - l));
        return proceed;
    }

}
