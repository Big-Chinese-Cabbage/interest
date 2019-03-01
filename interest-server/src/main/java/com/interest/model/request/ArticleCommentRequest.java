package com.interest.model.request;

import io.swagger.annotations.ApiModelProperty;

public class ArticleCommentRequest {

    @ApiModelProperty("文章id")
    private Integer articleid;

    @ApiModelProperty("文章所有者id")
    private Integer articleOwnerId;

    @ApiModelProperty("一级回复不传值或者传null，二级回复必须传一级回复id")
    private Integer parentid;

    @ApiModelProperty("评论")
    private String comment;

    @ApiModelProperty("回复评论人id（一级回复无需传值）")
    private Integer replierId;

    @ApiModelProperty("回复评论人的姓名（一级回复无需传值）")
    private String replierName;

    public Integer getArticleid() {
        return articleid;
    }

    public void setArticleid(Integer articleid) {
        this.articleid = articleid;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getReplierId() {
        return replierId;
    }

    public void setReplierId(Integer replierId) {
        this.replierId = replierId;
    }

    public String getReplierName() {
        return replierName;
    }

    public void setReplierName(String replierName) {
        this.replierName = replierName;
    }

    public Integer getArticleOwnerId() {
        return articleOwnerId;
    }

    public void setArticleOwnerId(Integer articleOwnerId) {
        this.articleOwnerId = articleOwnerId;
    }
}
