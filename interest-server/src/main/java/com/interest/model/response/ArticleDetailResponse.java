package com.interest.model.response;

import lombok.Data;

@Data
public class ArticleDetailResponse {

    private int id;

    private String title;

    private String content;

    private int clickRate;

    private int commentCount;

    private String createTime;

    private int userid;

    private String userName;

    private String userHeadImg;

    private String githuburl;

}
