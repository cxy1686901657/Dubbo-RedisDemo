package com.qc.yx.enums;


import lombok.Getter;

/**
 * @author qc
 * @date 2019/8/9
 * @description
 * @model common
 * @project Dubbo-RedisDemo
 */
@Getter
public enum  StudentSexEnum {
    Man(0,"男"),Women(1,"女");
    private Integer code;
    private String msg;

    StudentSexEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
