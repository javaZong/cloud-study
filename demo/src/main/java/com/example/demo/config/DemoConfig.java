package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class DemoConfig {

    @Bean(name = "coopGroupThreadPoolExecutor")
    public ThreadPoolTaskExecutor coopGroupThreadPoolExecutor() {
        ThreadPoolTaskExecutor threadPoolExecutor = new ThreadPoolTaskExecutor();
//        int processNum = Runtime.getRuntime().availableProcessors(); // 返回可用处理器的Java虚拟机的数量
//        System.out.println(processNum);
//        int corePoolSize = (int) (processNum / (1 - 0.2));
//        int maxPoolSize = (int) (processNum / (1 - 0.5));
        int corePoolSize = 10;
        int maxPoolSize = corePoolSize * 10;
        threadPoolExecutor.setCorePoolSize(corePoolSize); // 核心池大小
        threadPoolExecutor.setMaxPoolSize(maxPoolSize); // 最大线程数
        threadPoolExecutor.setQueueCapacity(maxPoolSize * 50); // 队列程度
        threadPoolExecutor.setKeepAliveSeconds(300);// 线程空闲时间
        threadPoolExecutor.setThreadNamePrefix("coop-goup-"); // 线程名字前缀
        return threadPoolExecutor;
    }
}
