package com.interest.model.entity;

import lombok.Data;

@Data
public class MsgRecordEntity {

    private Integer id;

    private Integer ownerid;

    private Integer form;

    private Integer replyCardId;

    private Integer commentId;

    private String replytime;

    private Integer isread;

}
