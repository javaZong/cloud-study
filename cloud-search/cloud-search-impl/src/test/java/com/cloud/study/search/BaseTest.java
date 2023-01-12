package com.cloud.study.search;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.transport.endpoints.BooleanResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

/**
 * 单测-基础父类
 */
@SpringBootTest
@AutoConfigureMockMvc
public class BaseTest {

    @Autowired
    private ElasticsearchClient elasticsearchClient;

    @Test
    public void test() {

        try {
            BooleanResponse booleanResponse = elasticsearchClient.ping();
            System.out.println(booleanResponse.value());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
