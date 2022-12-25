package com.cloud.study.user.service;

import com.cloud.study.common.resp.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("cloud-search")
public interface SearchService {

    @GetMapping("/search/base/hello")
    ResponseResult<String> hello();

}
