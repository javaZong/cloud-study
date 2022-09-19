package com.cloud.study.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserInfoController {

    @RequestMapping("info")
    public String test() {
        return "hello world!";
    }
}
