package com.interest.annotation.handler;

import lombok.Data;

import java.io.Serializable;

@Data
public class InterestException implements Serializable {

    private String createTime;

    private String location;

    private String message;

}
