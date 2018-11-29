package com.interest.model.utils;

/**
 * 返回的JSON数据结构标准
 *
 * @param <T>
 */
public class ResponseWrapper<T> {

    private String status;

    private String message;

    private T data;

    public ResponseWrapper(String status) {
        this.status = status;
    }

    public ResponseWrapper(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResponseWrapper(String status, T data) {
        this.status = status;
        this.data = data;
    }

    public ResponseWrapper(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
