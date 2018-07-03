package com.interest.dao;

import java.util.List;

import com.interest.model.InterestEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InterestDao {

	public List<InterestEntity> getInsterest(@Param("title") String title);

	public InterestEntity getInsterestById(@Param("id") int id);

}
