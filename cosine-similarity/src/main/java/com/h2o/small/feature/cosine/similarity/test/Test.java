package com.h2o.small.feature.cosine.similarity.test;

import com.h2o.small.feature.cosine.similarity.util.CosineSimilarity;

/**
 * @author zqb
 * @title: Test
 * @description: TODO
 * @date 2021/12/2812:35
 */
public class Test {
    public static final String content1 = "基本思路是";

    public static final String content2 = "今天小小和妈妈一起去草原里采草莓，今天的草莓味道特别好，而且价格还挺实惠的";


    public static void main(String[] args) {

        double score = CosineSimilarity.getSimilarity(content1, content2);
        System.out.println("相似度：" + score);

        score = CosineSimilarity.getSimilarity(content1, content1);
        System.out.println("相似度：" + score);
    }

}
