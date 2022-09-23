package com.cloud.study.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

@EnableDiscoveryClient
@SpringBootApplication
public class CloudUserApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(CloudUserApplication.class, args);

        //当动态配置刷新时，会更新到 Enviroment中，因此这里每隔一秒中从Enviroment中获取配置
        String userName = applicationContext.getEnvironment().getProperty("cloud.user.test");
        System.out.println(applicationContext.getEnvironment().getProperty("useLocalCache"));
        System.err.println("user name :" + userName);
    }

}
