package com.interest.model.response;

import lombok.Data;

@Data
public class ArticleResponse {

    private int id;

    private String title;

    private String info;

    private int clickRate;

    private int commentCount;

    private String createTime;

    private int userid;

    private String userName;

    private String userHeadImg;

    private Integer top;

}
