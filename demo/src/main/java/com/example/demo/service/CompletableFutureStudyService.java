package com.example.demo.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

@Service
public class CompletableFutureStudyService {
    @Autowired
    @Qualifier(value = "coopGroupThreadPoolExecutor")
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;


    public String exec(int i) {
        String name=Thread.currentThread().getName() + i;
        try {
            if(i==5){
                throw new RuntimeException("异常");
            }
            System.out.println(i);
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return name;

    }
}
