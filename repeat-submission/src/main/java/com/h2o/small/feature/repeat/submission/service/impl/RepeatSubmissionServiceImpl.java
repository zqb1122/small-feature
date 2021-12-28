package com.h2o.small.feature.repeat.submission.service.impl;

import com.h2o.small.feature.repeat.submission.service.IRepeatSubmissionService;
import org.springframework.stereotype.Service;

/**
 * @author zqb
 * @title: RepeatSubmissionServiceImpl
 * @description: TODO
 * @date 2021/12/2216:04
 */
@Service
public class RepeatSubmissionServiceImpl implements IRepeatSubmissionService {


    @Override
    public String save(String id, String name) {
        return id;
    }
}
