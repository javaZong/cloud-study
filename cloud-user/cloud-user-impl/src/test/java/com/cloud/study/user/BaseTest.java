package com.cloud.study.user;

import com.cloud.study.user.service.UserInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 单测-基础父类
 */
@SpringBootTest
@AutoConfigureMockMvc
public class BaseTest {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void test() {
        System.out.println(userInfoService.getCache());
    }
}
