package com.h2o.small.feature.repeat.submission.annotation;

import java.lang.annotation.*;

/**
 * @author zqb
 * @title: Repeat
 * @description: TODO
 * @date 2021/12/2216:10
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Repeat {
    /**
     * key 名称，不给默认是类名称+方法名
     *
     * @return
     */
    String value() default "";

    /**
     * 限制，默认一次
     *
     * @return
     */
    int limit() default 1;

    /**
     * 过期时间，默认5秒
     *
     * @return
     */
    int expire() default 5;
}
