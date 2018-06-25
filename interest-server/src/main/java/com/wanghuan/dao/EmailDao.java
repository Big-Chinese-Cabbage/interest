package com.wanghuan.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.wanghuan.model.EmailEntity;

@Mapper
public interface EmailDao {

	public void insertEntity(EmailEntity emailEntity);

	public List<EmailEntity> emailsList(@Param("pageSize") int pageSize, @Param("start") int start);

	public Integer emailsSize(@Param("pageSize") int pageSize, @Param("start") int start);

}
