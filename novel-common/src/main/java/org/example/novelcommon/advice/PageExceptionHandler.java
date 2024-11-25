package org.example.novelcommon.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Author：hb
 * @Package：org.example.novelcommon.advice
 * @Project：my
 * @Date：21/11/2024 4:27 pm
 */
@Slf4j
@ControllerAdvice(basePackages = "org.example.novel.controller.page")
public class PageExceptionHandler {
    /**
     * 处理所有异常
     */
    @ExceptionHandler(Exception.class)
    public String handlerException(Exception e) {
        log.error(e.getMessage(), e);
        //跳转页面过程中出现异常时统一跳转到404页面
        return "404";
    }
}
