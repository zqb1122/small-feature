package com.h2o.small.feature.common.exception;

import lombok.Data;

@Data
public class SmallFeatureException extends RuntimeException {

    private String code;

    private String message;


    public SmallFeatureException(String code, String message) {
        super(message);
        this.message = message;
        this.code = code;
    }

    public SmallFeatureException(String message) {
        super(message);
        this.message = message;
        this.code = ExceptionEnum.FAIL.code;
    }

    public static SmallFeatureException error(ExceptionEnum e) {
        return new SmallFeatureException(e.code, e.message);
    }

    public static SmallFeatureException error(String message) {
        return new SmallFeatureException(message);
    }
}
