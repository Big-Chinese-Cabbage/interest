package com.interest.model.entity;

import lombok.Data;

/**
 * @author wanghuan
 */
@Data
public class ArticleEntity {

    private Integer id;

    private String title;

    private String info;

    private String content;

    private Integer clickRate;

    private Integer commentCount;

    private Integer top;

    private String createTime;

    private String replyTime;

    private Integer userid;

    private Integer del;

}
