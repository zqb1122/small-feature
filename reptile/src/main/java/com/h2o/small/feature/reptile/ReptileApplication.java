package com.h2o.small.feature.reptile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zqb
 * @title: ReptileApplication
 * @description: TODO
 * @date 2021/12/2814:42
 */
@SpringBootApplication(scanBasePackages = "com.h2o")
public class ReptileApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReptileApplication.class, args);
    }
}
