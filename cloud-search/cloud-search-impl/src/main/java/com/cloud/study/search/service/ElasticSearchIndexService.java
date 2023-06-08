package com.cloud.study.search.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.BulkRequest;
import co.elastic.clients.elasticsearch.core.BulkResponse;
import co.elastic.clients.elasticsearch.core.bulk.BulkResponseItem;
import com.cloud.study.search.model.ProductInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * 添加es索引
 *
 * @author zongchao
 */
@Service
public class ElasticSearchIndexService {

    @Autowired
    private ElasticsearchClient elasticsearchClient;

    private Logger logger = LoggerFactory.getLogger(ElasticSearchIndexService.class);

    public void addIndex(List<ProductInfo> products) {

        BulkRequest.Builder br = new BulkRequest.Builder();

        for (ProductInfo product : products) {
            br.operations(op -> op
                    .index(idx -> idx
                            .index("products")
                            .id(String.valueOf(product.getId()))
                            .document(product)
                    )
            );
        }

        BulkResponse result = null;
        try {
            result = elasticsearchClient.bulk(br.build());
        } catch (IOException e) {
            logger.error("addIndex error,", e);
            return;
        }

// Log errors, if any
        if (result.errors()) {
            logger.error("Bulk had errors");
            for (BulkResponseItem item : result.items()) {
                if (item.error() != null) {
                    logger.error(item.error().reason());
                }
            }
        }
    }
}
