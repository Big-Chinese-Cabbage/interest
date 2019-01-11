package com.interest.dao;

import java.util.List;

import com.interest.model.EmailEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EmailDao {

	void insertEntity(EmailEntity emailEntity);

	List<EmailEntity> emailsList(@Param("pageSize") int pageSize, @Param("start") int start);

	Integer emailsSize(@Param("pageSize") int pageSize, @Param("start") int start);

    void deleteEmails(@Param("groupId") List<String> groupId);
}
