package com.qc.yx.common;

import lombok.Getter;

/**
 * @author qc
 * @date 2019/8/10
 * @description
 * @model common
 * @project Dubbo-RedisDemo
 */
@Getter
public enum ResponseCode {
    SUCCESS(200, "SUCCESS"),
    ERROR(500, "ERROR"),
    NEED_LOGIN(111, "NEED_LOGIN"),
    ILLEGAL_ARGUMENT(222, "ILLEGAL_ARGUMENT"),
    NOT_FOUND(404, "NOT_FOUND");

    private final int code;
    private final String desc;

    ResponseCode(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

}