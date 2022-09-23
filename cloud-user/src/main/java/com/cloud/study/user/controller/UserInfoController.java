package com.cloud.study.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private Environment environment;

    @RequestMapping("info")
    public String test() {
        System.out.println(environment.getProperty("cloud.user.test"));
        return "hello world!";
    }
}
