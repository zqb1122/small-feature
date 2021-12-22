package com.h2o.small.feature.common.exception;

/**
 * 服务器错误枚举
 */
public enum ExceptionEnum {
    FAIL("500", "服务器错误"),
    ;

    public String code;

    public String message;

    ExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
