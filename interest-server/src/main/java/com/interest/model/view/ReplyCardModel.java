package com.interest.model.view;

import com.interest.model.ReplyCardEntity;

public class ReplyCardModel extends ReplyCardEntity {

    private String headimg;

    private String githuburl;

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
}
