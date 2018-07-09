package com.interest.dao;

import java.util.List;

import com.interest.model.ReplyCardEntity;
import com.interest.model.view.ReplyCardModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

	public List<ReplyCardModel> replycardList(@Param("postcardid") int postcardid, @Param("pageSize") int pageSize,
											  @Param("start") int start);

	public Integer replycardSize(@Param("postcardid") int postcardid, @Param("pageSize") int pageSize,
			@Param("start") int start);

	public void delReplyByPostcardid(@Param("groupId") List<String> groupId);

}
