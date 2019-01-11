package com.interest.dao;

import java.util.List;

import com.interest.model.ReplyCardEntity;
import com.interest.model.view.ReplyCardModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ReplyCardDao {


	void insertEntity(ReplyCardEntity replyCardEntity);

	List<ReplyCardModel> replycardList(@Param("postcardid") int postcardid, @Param("pageSize") int pageSize,
											  @Param("start") int start);

	Integer replycardSize(@Param("postcardid") int postcardid, @Param("pageSize") int pageSize,
			@Param("start") int start);

	void delReplyByPostcardid(@Param("groupId") List<String> groupId);

	Integer replyCardCountByPostId(@Param("postcardid") int id);

}
