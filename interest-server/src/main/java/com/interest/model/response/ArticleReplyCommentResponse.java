package com.interest.model.response;

import com.interest.model.entity.ArticleCommentEntity;

public class ArticleReplyCommentResponse extends ArticleCommentEntity {

    private String userName;

    private String userHeadImg;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserHeadImg() {
        return userHeadImg;
    }

    public void setUserHeadImg(String userHeadImg) {
        this.userHeadImg = userHeadImg;
    }
}
