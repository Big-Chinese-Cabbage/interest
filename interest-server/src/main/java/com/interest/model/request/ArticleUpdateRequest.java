package com.interest.model.request;

import lombok.Data;

@Data
public class ArticleUpdateRequest {

    private Integer id;

    private String title;

    private String content;

}
