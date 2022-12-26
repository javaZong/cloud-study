package com.cloud.study.common.resp;

import com.cloud.study.common.resp.enums.RespCodeEnum;

public class ResponseResult<T> {

    private RespControlData controlData;
    private T data;

    public ResponseResult(){

    }

    public ResponseResult(RespControlData controlData, T data) {
        this.controlData = controlData;
        this.data = data;
    }

    public static <T> ResponseResult<T> of(T data) {
        return new ResponseResult<>(RespControlData.of(RespCodeEnum.SUCCESS), data);
    }

    public RespControlData getControlData() {
        return controlData;
    }

    public T getData() {
        return data;
    }
}
