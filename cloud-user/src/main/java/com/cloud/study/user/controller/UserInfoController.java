package com.cloud.study.user.controller;

import com.cloud.study.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("info")
    public String test() {
        return userInfoService.getCache();
    }
}
