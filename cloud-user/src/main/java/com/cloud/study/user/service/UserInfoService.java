package com.cloud.study.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class UserInfoService {

    @Autowired
    private Environment environment;
    @Value("${cloud.user.cache}")
    private String cacheValue;

    public String getCache() {
        String cache = environment.getProperty("cloud.user.test");
        System.out.println(cacheValue);
        System.out.println(cache);
        return cacheValue;
    }

}
