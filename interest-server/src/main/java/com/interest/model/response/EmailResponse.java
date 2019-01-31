package com.interest.model.response;

import com.interest.model.entity.EmailEntity;

public class EmailResponse extends EmailEntity {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
