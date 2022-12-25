package com.cloud.study.search.controller;

import com.cloud.study.common.resp.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 基本搜索
 *
 * @author zongchao
 */
@RestController
@RequestMapping("search/base")
public class BaseSearchController {


    @GetMapping("hello")
    public ResponseResult<String> hello() {
        return ResponseResult.of("cloud-search:hello world");
    }
}
