package com.h2o.small.feature.repeat.submission.controller;

import com.h2o.small.feature.common.util.R;
import com.h2o.small.feature.repeat.submission.annotation.Repeat;
import com.h2o.small.feature.repeat.submission.service.IRepeatSubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zqb
 * @title: TestController
 * @description: TODO
 * @date 2021/12/22 16:03
 */
@RestController()
@RequestMapping("/test")
public class TestController {

    @Autowired
    private IRepeatSubmissionService repeatSubmissionService;

    @Repeat
    @PostMapping("/save")
    public R save(String id, String name) {
        return R.success(repeatSubmissionService.save(id, name));
    }
}
