package com.interest.model.response;

import lombok.Data;

@Data
public class EmailResponse {

    private Integer id;

    private String title;

    private String email;

    private String name;

    private String content;

    private String createtime;

    private Integer userid;

    private String username;

}
