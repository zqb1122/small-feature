package com.h2o.small.feature.login.limit.controller;

import com.h2o.small.feature.common.util.R;
import com.h2o.small.feature.login.limit.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zqb
 * @title: TestController
 * @description: TODO
 * @date 2021/12/2213:06
 */
@RestController
@RequestMapping("/login")
public class TestController {

    @Autowired
    private ILoginService loginService;

    @GetMapping("/login")
    public R login(String name,String password){
        return R.success(loginService.login(name,password));
    }
}
