package com.interest.dao;

import java.util.List;

import com.interest.model.PostCardEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PostCardDao {

	public List<PostCardEntity> postcardList(@Param("interestid") String interestid, @Param("pageSize") int pageSize,
                                             @Param("start") int start);

	public Integer postcardSize(@Param("interestid") String interestid, @Param("pageSize") int pageSize,
			@Param("start") int start);

	public void insertEntity(PostCardEntity postCardEntity);

	public PostCardEntity getPostcard(@Param("id") int id);

	public void updateCreatetiem(@Param("id") int id, @Param("replytime") String replytime);

	public void deletePostcards(@Param("groupId") List<String> groupId);

}
