package com.interest.model.utils;

import io.swagger.annotations.ApiModelProperty;

/**
 * 返回的JSON数据结构标准
 *
 * @param <T>
 */
public class ResponseWrapper<T> {

    @ApiModelProperty("状态码")
    private String status = ResponseStatus.OK.getValue();

    @ApiModelProperty("信息")
    private String message = "success";

    @ApiModelProperty("接口返回数据")
    private T data;

    public ResponseWrapper(ResponseStatus status, String message) {
        this.status = status.getValue();
        this.message = message;
    }

    public ResponseWrapper(ResponseStatus status, T data) {
        this.status = status.getValue();
        this.data = data;
    }

    public ResponseWrapper(ResponseStatus status, String message, T data) {
        this.status = status.getValue();
        this.message = message;
        this.data = data;
    }

    public ResponseWrapper(T data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status.getValue();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
