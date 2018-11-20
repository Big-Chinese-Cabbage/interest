package com.interest.model.utils;

/**
 * 返回的JSON数据结构标准
 *
 * @param <T>
 */
public class RepsonseWraper<T> {

    private String state;

    private String message;

    private T data;

    public RepsonseWraper(String state) {
        this.state = state;
    }

    public RepsonseWraper(String state, String message) {
        this.state = state;
        this.message = message;
    }

    public RepsonseWraper(String state, T data) {
        this.state = state;
        this.data = data;
    }

    public RepsonseWraper(String state, String message, T data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
