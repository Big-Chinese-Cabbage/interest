package com.interest.model.response;

import com.interest.model.entity.ReplyCardEntity;

public class ReplyCardResponse extends ReplyCardEntity {

    private String headimg;

    private String githuburl;

    private String username;

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }

    public String getGithuburl() {
        return githuburl;
    }

    public void setGithuburl(String githuburl) {
        this.githuburl = githuburl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
