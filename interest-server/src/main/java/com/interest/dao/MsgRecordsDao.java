package com.interest.dao;

import com.interest.model.MsgRecordEntity;
import com.interest.model.view.MsgRecordModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MsgRecordsDao {


    void addMsg(MsgRecordEntity entity);

    int getUnreadMsgCount(Integer userid);

    List<MsgRecordModel> getMsgListByUserid(@Param("userid") int userid,@Param("pageSize") int pageSize,@Param("start") int start);

    int getMsgSizeByUserid(@Param("userid") int userid);

    void updateMsgRecordIsread(@Param("id") Integer msgRecordId,@Param("isread") int isread);
}
