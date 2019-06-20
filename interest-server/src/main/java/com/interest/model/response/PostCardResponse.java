package com.interest.model.response;

import lombok.Data;

@Data
public class PostCardResponse {

    private String headimg;

    private String githuburl;

    private String username;

    private Integer replyCount;

    private Integer id;

    private String title;

    private String content;

    private Integer interestid;

    private String createtime;

    private String replytime;

    private Integer userid;
}
