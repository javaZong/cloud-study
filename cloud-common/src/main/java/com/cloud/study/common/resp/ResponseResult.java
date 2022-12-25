package com.cloud.study.common.resp;

import com.cloud.study.common.resp.enums.RespCodeEnum;

public class ResponseResult<T> {

    private RespControlData controlData;
    private T data;

    private ResponseResult(RespControlData controlData, T data) {
        this.controlData = controlData;
        this.data = data;
    }

    public static <T> ResponseResult<T> of(T data) {
        return new ResponseResult<>(RespControlData.of(RespCodeEnum.SUCCESS), data);
    }
}
