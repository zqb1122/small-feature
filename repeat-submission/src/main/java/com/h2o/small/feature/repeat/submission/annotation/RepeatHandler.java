package com.h2o.small.feature.repeat.submission.annotation;

import com.h2o.small.feature.redis.component.RedisComponent;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author zqb
 * @title: RepeatHandler
 * @description: TODO
 * @date 2021/12/2216:11
 */
@Aspect
@Component
public class RepeatHandler {

    @Autowired
    private RedisComponent redisComponent;

    private DefaultRedisScript<Long> getRedisScript;

    @PostConstruct
    public void init() {
        getRedisScript = new DefaultRedisScript<>();
        getRedisScript.setResultType(Long.class);
        getRedisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("ipLimiter.lua")));
    }

    @Around("@annotation(repeat)")
    public Object around(ProceedingJoinPoint jp, Repeat repeat) throws Throwable {
        //1.获取用户行为日志(ip,username,operation,method,params,time,createdTime)
        //获取类的字节码对象，通过字节码对象获取方法信息
        Class<?> targetCls=jp.getTarget().getClass();
        //获取方法签名(通过此签名获取目标方法信息)
        MethodSignature ms=(MethodSignature)jp.getSignature();
        //获取目标方法上的注解指定的操作名称
        Method targetMethod=
                targetCls.getDeclaredMethod(
                        ms.getName(),
                        ms.getParameterTypes());

        System.out.println("targetMethod="+targetMethod);
        //获取目标方法名(目标类型+方法名)
        String targetClsName=targetCls.getName();
        String targetObjectMethodName=targetClsName+":"+ms.getName();
        //获取请求参数
        String targetMethodParams= Arrays.toString(jp.getArgs());

        Object o = redisComponent.get(targetObjectMethodName);


        return null;
    }
}
