package com.cloud.study.common.resp.enums;

public enum RespCodeEnum {
    SUCCESS(0,"");

    private int code;
    private String msg;

    RespCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
