package com.xurui.youth.exception;

import com.xurui.youth.model.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常兜底
 * Created by XuRui on 2018/4/19.
 */
@Slf4j
@ControllerAdvice
@ResponseBody
public class ExceptionHandle {

    private static final String errorMessage = "系统异常, 请稍后重试。";

    @ExceptionHandler(Exception.class)
    public Response handleException(Exception e) {
        String message = errorMessage;
        if (!StringUtils.isEmpty(e.getMessage())) {
            message = e.getMessage();
        }
        log.warn(message, e);
        return Response.failOfMessage(message);
    }
}
