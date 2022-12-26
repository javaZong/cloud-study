package com.cloud.study.common.resp;

import com.cloud.study.common.resp.enums.RespCodeEnum;

public  class RespControlData {
    private  long serverTime;

    private  int error;

    private  String message;

    private  String reqId;

    public RespControlData(){};

    private RespControlData(long serverTime, int error, String message, String reqId) {
        this.serverTime = serverTime;
        this.error = error;
        this.message = message;
        this.reqId = reqId;
    }

    public static RespControlData of(RespCodeEnum retCode) {
        return new RespControlData(System.currentTimeMillis(), retCode.getCode(), retCode.getMsg(), "");
    }

    public static RespControlData of(int error, String message) {
        return new RespControlData(System.currentTimeMillis(), error, message, "");
    }

    public long getServerTime() {
        return serverTime;
    }

    public int getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getReqId() {
        return reqId;
    }
}
