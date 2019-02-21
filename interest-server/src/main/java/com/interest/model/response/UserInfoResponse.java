package com.interest.model.response;

import io.swagger.annotations.ApiModelProperty;

public class UserInfoResponse {

    @ApiModelProperty("头像url")
    private String headimg;

    @ApiModelProperty("用户名")
    private String name;

    @ApiModelProperty("个人主页")
    private String url;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("个人简介")
    private String info;

    @ApiModelProperty("位置")
    private String location;

    @ApiModelProperty("技能")
    private String skill;

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
