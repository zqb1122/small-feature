package com.h2o.small.feature.login.limit.service.impl;

import com.google.common.collect.Lists;
import com.h2o.small.feature.common.exception.SmallFeatureException;
import com.h2o.small.feature.login.limit.service.ILoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author zqb
 * @title: LoginServiceImpl
 * @description: TODO
 * @date 2021/12/2213:15
 */
@Service
@Slf4j
public class LoginServiceImpl implements ILoginService {

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * getRedisScript 读取脚本工具类
     * 这里设置为Long,是因为ipLimiter.lua 脚本返回的是数字类型
     */
    private DefaultRedisScript<Long> getRedisScript;

    @PostConstruct
    public void init() {
        getRedisScript = new DefaultRedisScript<>();
        getRedisScript.setResultType(Long.class);
        getRedisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("login_script.lua")));
    }


    @Override
    public String login(String name, String password) {
        Long execute = (Long) redisTemplate.execute(getRedisScript, Lists.newArrayList(name),5);
        if (0L == execute) {
            log.debug("暂无限制");
        }else{
            throw new SmallFeatureException("登录受限制，时间为："+execute/60);
        }
        if(!"123456".equals(password)){
            redisTemplate.execute(getRedisScript, Lists.newArrayList(name),5,10*60,1);
            throw new SmallFeatureException("用户名或是密码错误");
        }
        return null;
    }
}
