package com.qc.yx.enums;

import lombok.Getter;

/**
 * @author qc
 * @date 2019/8/11
 * @description
 * @model 设计原则
 * @project Dubbo-RedisDemo
 */
@Getter
public enum  ExceptionEnum {
    PARAM_ERROR(500,"参数错误"),
    STUDENT_EXIST(500,"student已存在");

     ExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    private Integer code;
    private String msg;

}
