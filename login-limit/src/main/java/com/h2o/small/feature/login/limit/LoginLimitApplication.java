package com.h2o.small.feature.login.limit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zqb
 * @title: LoginLimitApplication
 * @description: TODO
 * @date 2021/12/2213:05
 */
@SpringBootApplication(scanBasePackages = "com.h2o")
public class LoginLimitApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginLimitApplication.class, args);
    }
}
