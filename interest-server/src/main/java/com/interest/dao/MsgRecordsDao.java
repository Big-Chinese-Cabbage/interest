package com.interest.dao;

import com.interest.model.MsgRecordEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MsgRecordsDao {


    void addMsg(MsgRecordEntity entity);
}
