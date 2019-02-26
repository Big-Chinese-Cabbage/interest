package com.interest.model.entity;

public class MsgRecordEntity {

    private Integer id;

    private Integer ownerid;

    private Integer form;

    private Integer replyCardId;

    private Integer commentId;

    private String replytime;

    private Integer isread;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(Integer ownerid) {
        this.ownerid = ownerid;
    }

    public String getReplytime() {
        return replytime;
    }

    public void setReplytime(String replytime) {
        this.replytime = replytime;
    }

    public Integer getIsread() {
        return isread;
    }

    public void setIsread(Integer isread) {
        this.isread = isread;
    }

    public Integer getForm() {
        return form;
    }

    public void setForm(Integer form) {
        this.form = form;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getReplyCardId() {
        return replyCardId;
    }

    public void setReplyCardId(Integer replyCardId) {
        this.replyCardId = replyCardId;
    }
}
