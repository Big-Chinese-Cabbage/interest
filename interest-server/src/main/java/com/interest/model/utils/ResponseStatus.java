package com.interest.model.utils;

public enum ResponseStatus {

    /**
     *  请求成功状态码
     */
    OK("1001","success"),

    /**
     *  请求失败状态码
     */
    FAIL("4001","fail");

    private final String value;

    private final String reasonPhrase;

    ResponseStatus(String value, String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }

    public String getValue() {
        return value;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }
}
