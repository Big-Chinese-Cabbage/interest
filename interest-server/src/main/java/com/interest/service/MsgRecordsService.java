package com.interest.service;

import com.interest.model.MsgRecordEntity;

public interface MsgRecordsService {

    /**
     * 添加消息记录
     * @param entity 消息实体
     * @return 添加是否成功
     */
    boolean addMsg(MsgRecordEntity entity);

    /**
     * 查询未读消息条数
     * @param userid
     * @return
     */
    int getUnreadMsgCount(Integer userid);
}
