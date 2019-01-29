package com.interest.model.response;

import com.interest.model.entity.EmailEntity;

public class EmailModel extends EmailEntity {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
