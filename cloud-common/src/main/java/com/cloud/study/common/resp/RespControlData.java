package com.cloud.study.common.resp;

import com.cloud.study.common.resp.enums.RespCodeEnum;

public final class RespControlData {
    private final long serverTime;

    private final int error;

    private final String message;

    private final String reqId;

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
}
