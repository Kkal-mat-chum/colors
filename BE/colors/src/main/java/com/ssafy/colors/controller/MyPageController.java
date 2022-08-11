package com.ssafy.colors.controller;

import com.ssafy.colors.service.MyPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mypage")
public class MyPageController {

    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    @Autowired
    MyPageService myPageService;

}
