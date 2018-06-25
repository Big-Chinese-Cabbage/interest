package com.wanghuan.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.wanghuan.model.ReplyCardEntity;

@Mapper
public interface ReplyCardDao {

	// public List<PostCardEntity> postcardList(@Param("interestid") int interestid,
	// @Param("pageSize") int pageSize,
	// @Param("start") int start);
	//
	// public Integer postcardSize(@Param("interestid") int interestid,
	// @Param("pageSize") int pageSize,
	// @Param("start") int start);

	public void insertEntity(ReplyCardEntity replyCardEntity);

	// public PostCardEntity getPostcard(@Param("id") int id);

	public List<ReplyCardEntity> replycardList(@Param("postcardid") int postcardid, @Param("pageSize") int pageSize,
			@Param("start") int start);

	public Integer replycardSize(@Param("postcardid") int postcardid, @Param("pageSize") int pageSize,
			@Param("start") int start);

	public void delReplyByPostcardid(@Param("groupId") List<String> groupId);

}
