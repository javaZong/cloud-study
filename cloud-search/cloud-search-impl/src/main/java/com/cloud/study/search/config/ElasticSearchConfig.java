package com.cloud.study.search.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * elasticsearch配置
 */
@Configuration
public class ElasticSearchConfig {
    @Value("${elasticsearch.host}")
    private String host;
    @Value("${elasticsearch.port}")
    private int port;
    @Value("${elasticsearch.connTimeout}")
    private int connTimeout;
    @Value("${elasticsearch.socketTimeout}")
    private int socketTimeout;
    @Value("${elasticsearch.connectionRequestTimeout}")
    private int connectionRequestTimeout;

    @Bean
    public ElasticsearchClient initRestClient() {
        RestClient restClient = RestClient.builder(new HttpHost(host, port)).build();
        // Create the transport with a Jackson mapper
        ElasticsearchTransport transport = new RestClientTransport(
                restClient, new JacksonJsonpMapper());

        // And create the API client
        ElasticsearchClient client = new ElasticsearchClient(transport);
        return client;
    }
}
