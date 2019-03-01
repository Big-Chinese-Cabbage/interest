package com.interest.exception;

public class ArticleException extends RuntimeException {

    private String code;

    public ArticleException(String code,String message){
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
