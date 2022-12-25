package com.cloud.study.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.cloud.study"})
public class CloudUserApplication {

    public static void main(String[] args) {

        SpringApplication.run(CloudUserApplication.class, args);

    }

}
