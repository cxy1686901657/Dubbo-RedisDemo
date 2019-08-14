package com.qc.yx.exception.handler;

import com.qc.yx.common.ServerResponse;
import com.qc.yx.exception.GlobalException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author qc
 * @date 2019/8/11
 * @description
 * @model 设计原则
 * @project Dubbo-RedisDemo
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GlobalException.class)
    @ResponseBody
    public ServerResponse handlerGlobalException(GlobalException ex){
        return ServerResponse.createByErrorCodeMessage(ex.getCode(), ex.getMessage());
    }
}
