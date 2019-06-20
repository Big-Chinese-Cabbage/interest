package com.interest.model.response;

import lombok.Data;

@Data
public class MsgRecordResponse {

    private Integer id;

    private Integer ownerid;

    private Integer form;

    private Integer replyCardId;

    private Integer commentId;

    private String replytime;

    private Integer isread;

    private Integer replyUserid;

    private String replyUserHeadimg;

    private String replyUsername;

    private String replyContent;

    private String title;

    private Integer toId;

}
