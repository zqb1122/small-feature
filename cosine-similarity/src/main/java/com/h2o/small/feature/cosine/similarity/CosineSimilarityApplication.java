package com.h2o.small.feature.cosine.similarity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zqb
 * @title: CosineSimilarityApplication
 * @description: TODO
 * @date 2021/12/2812:28
 */
@SpringBootApplication(scanBasePackages = "com.h2o")
public class CosineSimilarityApplication {
    public static void main(String[] args) {
        SpringApplication.run(CosineSimilarityApplication.class, args);
    }
}
