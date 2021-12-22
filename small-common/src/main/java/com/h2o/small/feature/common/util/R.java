package com.h2o.small.feature.common.util;

import com.h2o.small.feature.common.exception.ExceptionEnum;
import com.h2o.small.feature.common.exception.SmallFeatureException;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zqb
 * @title: R
 * @description: TODO
 * @date 2021/12/2213:10
 */
@Data
@NoArgsConstructor
public class R<T> implements Serializable {
    private static final long serialVersionUID = 4252277967420071914L;

    private boolean success = true;

    private String code = "200";

    private String message = "成功";

    private T data;

    private R(T data) {
        this.data = data;
    }

    private R(ExceptionEnum e) {
        this.success = false;
        this.code = e.code;
        this.message = e.message;
    }

    private R(SmallFeatureException e) {
        this.success = false;
        this.code = e.getCode();
        this.message = e.getMessage();
    }


    public static <T> R success() {
        return new R<T>();
    }

    public static <T> R success(T data) {
        return new R<T>(data);
    }

    public static <T> R fail() {
        return new R<T>(ExceptionEnum.FAIL);
    }

    public static  R fail(String message) {
        return new R(new SmallFeatureException(ExceptionEnum.FAIL.code,message));
    }


    public static <T> R fail(SmallFeatureException e) {
        return new R<T>(e);
    }

    public static <T> R fail(ExceptionEnum e) {
        return new R<T>(e);
    }

}

