package com.qc.yx.exception;

import com.qc.yx.enums.ExceptionEnum;
import lombok.Getter;

/**
 * @author qc
 * @date 2019/8/11
 * @description
 * @model 设计原则
 * @project Dubbo-RedisDemo
 */
@Getter
public class GlobalException extends RuntimeException{
    private Integer code;
    public GlobalException(ExceptionEnum exceptionEnum){
        super(exceptionEnum.getMsg());
        this.code=exceptionEnum.getCode();
    }
    public GlobalException(ExceptionEnum exceptionEnum,String msg) {
        super(msg);
        this.code=exceptionEnum.getCode();
    }
}
