package org.example.novel.common.exception;


import org.apache.shiro.authz.AuthorizationException;
import org.example.novel.common.config.Constant;
import org.example.novel.common.domain.SysLog;
import org.example.novel.common.service.SysLogService;
import org.example.novel.common.utils.HttpServletUtils;
import org.example.novel.common.utils.R;
import org.example.novel.common.utils.ShiroUtils;
import org.example.novel.system.domain.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 异常处理器
 */
@RestControllerAdvice
public class CommonExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    SysLogService logService;

    /**
     * 自定义业务异常处理
     */
    @ExceptionHandler(BusinessException.class)
    public R handleBusinessException(BusinessException e) {
        logger.error(e.getMessage(), e);
        return R.error(e.getCode(),e.getMessage());
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public R handleDuplicateKeyException(DuplicateKeyException e) {
        logger.error(e.getMessage(), e);
        return R.error("数据库中已存在该记录");
    }

    @ExceptionHandler(org.springframework.web.servlet.NoHandlerFoundException.class)
    public R noHandlerFoundException(org.springframework.web.servlet.NoHandlerFoundException e) {
        logger.error(e.getMessage(), e);
        return R.error(404, "没找找到页面");
    }

    @ExceptionHandler(AuthorizationException.class)
    public Object handleAuthorizationException(AuthorizationException e, HttpServletRequest request) {
        logger.error(e.getMessage(), e);
        if (HttpServletUtils.jsAjax(request)) {
            return R.error(403, "未授权");
        }
        return new ModelAndView("error/403");
    }


    @ExceptionHandler({Exception.class})
    public Object handleException(Exception e, HttpServletRequest request) {
        SysLog logDO = new SysLog();
        logDO.setGmtCreate(new Date());
        logDO.setOperation(Constant.LOG_ERROR);
        logDO.setMethod(request.getRequestURL().toString());
        logDO.setParams(e.toString());
        SysUser current = ShiroUtils.getUser();
        if(null!=current){
            logDO.setUserId(current.getUserId());
            logDO.setUsername(current.getUsername());
        }
        logService.save(logDO);
        logger.error(e.getMessage(), e);
        if (HttpServletUtils.jsAjax(request)) {
            return R.error(500, "服务器错误，请联系管理员");
        }
        return new ModelAndView("error/500");
    }
}
