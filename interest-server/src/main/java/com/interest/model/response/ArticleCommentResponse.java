package com.interest.model.response;

import com.interest.model.entity.ArticleCommentEntity;

import java.util.List;

public class ArticleCommentResponse extends ArticleCommentEntity {

    private String userName;

    private String userHeadImg;

    private Integer childCommentsCount;

    private List<ArticleReplyCommentResponse> childComments;

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

    public Integer getChildCommentsCount() {
        return childCommentsCount;
    }

    public void setChildCommentsCount(Integer childCommentsCount) {
        this.childCommentsCount = childCommentsCount;
    }

    public List<ArticleReplyCommentResponse> getChildComments() {
        return childComments;
    }

    public void setChildComments(List<ArticleReplyCommentResponse> childComments) {
        this.childComments = childComments;
        this.childCommentsCount = childComments.size();
    }
}
