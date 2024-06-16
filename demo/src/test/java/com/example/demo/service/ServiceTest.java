package com.example.demo.service;

import com.example.demo.DemoApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ServiceTest extends DemoApplicationTests {

    @Autowired
    @Qualifier(value = "coopGroupThreadPoolExecutor")
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Autowired
    private CompletableFutureStudyService completableFutureStudyService;

    @Test
    public void test() throws ExecutionException, InterruptedException {
        List<CompletableFuture<String>> list=new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int j = i;
            CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() ->
                            completableFutureStudyService.exec(j)
                    , threadPoolTaskExecutor).exceptionally(ex->{
//                System.out.println(ex.getMessage());
                return null;
            });
            completableFuture.thenAccept(System.out::println);
            list.add(completableFuture);

        }
       CompletableFuture resultFuture= CompletableFuture.allOf(list.toArray(new CompletableFuture<?>[0]));
        resultFuture.get();

    }
}
