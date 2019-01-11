package com.interest.dao;

import java.util.List;

import com.interest.model.InterestEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InterestDao {

	List<InterestEntity> getInsterest(@Param("title") String title);

	InterestEntity getInsterestById(@Param("id") int id);

    void insertEntity(InterestEntity interestEntity);

	void updateEntity(InterestEntity interestEntity);

	List<InterestEntity> interestList(@Param("pageSize") int pageSize,@Param("start") int start);

	Integer interestSize();

	void deleteInterests(@Param("groupId") List<String> groupId);

    List<InterestEntity> getBanners();

	void updateBanners(@Param("groupId") List<String> groupId,@Param("banner") int i);
}
