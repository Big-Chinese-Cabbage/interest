package com.interest.model.utils;

public enum ResponseStatus {

    /**
     *  请求成功状态码
     */
    OK("2000","success"),

    /**
     * 请求失败
     */
    FAIL_4000("4000","FILE"),

    /**
     *  未认证
     */
    FAIL_4001("4001","未认证"),

    /**
     * 无权限
     */
    FAIL_4003("4003","无权限"),

    FAIL_6001("6001","发布文章超过当日次数");


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
