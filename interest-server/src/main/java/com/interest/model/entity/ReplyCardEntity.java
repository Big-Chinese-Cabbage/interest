package com.interest.model.entity;

import lombok.Data;

/**
 * @author wanghuan
 */
@Data
public class ReplyCardEntity {
    private Integer id;

    private String content;

    private Integer postcardid;

    private String createtime;

    private Integer userid;

}
