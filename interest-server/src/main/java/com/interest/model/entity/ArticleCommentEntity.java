package com.interest.model.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author wanghuan
 */
public class ArticleCommentEntity {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("文章id")
    private Integer articleid;

    @ApiModelProperty("用户id")
    private Integer userid;

    @ApiModelProperty("父级id")
    private Integer parentid;

    @ApiModelProperty("评论")
    private String comment;

    @ApiModelProperty("评论时间")
    private String createTime;

    @ApiModelProperty("回复评论人id")
    private Integer replierId;

    @ApiModelProperty("回复评论人的姓名")
    private String replierName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticleid() {
        return articleid;
    }

    public void setArticleid(Integer articleid) {
        this.articleid = articleid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
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
}
