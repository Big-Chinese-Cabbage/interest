package com.interest.model.view;

import com.interest.model.PostCardEntity;

public class PostCardModel extends PostCardEntity {

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
