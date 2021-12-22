package com.h2o.small.feature.login.limit.service;

/**
 * @author zqb
 * @title: ILoginService
 * @description: TODO
 * @date 2021/12/2213:14
 */
public interface ILoginService {
    /**
     * 登录
     * @param name
     * @param password
     * @return
     */
    String login(String name,String password);
}
