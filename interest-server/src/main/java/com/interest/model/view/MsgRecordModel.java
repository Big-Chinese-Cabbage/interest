package com.interest.model.view;

import com.interest.model.MsgRecordEntity;

public class MsgRecordModel extends MsgRecordEntity {

    private Integer replyUserid;

    private String replyUserHeadimg;

    private String replyUsername;

    private String replyContent;

    private String postCardTitle;

    public Integer getReplyUserid() {
        return replyUserid;
    }

    public void setReplyUserid(Integer replyUserid) {
        this.replyUserid = replyUserid;
    }

    public String getReplyUserHeadimg() {
        return replyUserHeadimg;
    }

    public void setReplyUserHeadimg(String replyUserHeadimg) {
        this.replyUserHeadimg = replyUserHeadimg;
    }

    public String getReplyUsername() {
        return replyUsername;
    }

    public void setReplyUsername(String replyUsername) {
        this.replyUsername = replyUsername;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public String getPostCardTitle() {
        return postCardTitle;
    }

    public void setPostCardTitle(String postCardTitle) {
        this.postCardTitle = postCardTitle;
    }
}
