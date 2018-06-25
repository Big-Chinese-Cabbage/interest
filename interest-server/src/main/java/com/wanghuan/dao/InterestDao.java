package com.wanghuan.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.wanghuan.model.InterestEntity;

@Mapper
public interface InterestDao {

	public List<InterestEntity> getInsterest(@Param("title") String title);

	public InterestEntity getInsterestById(@Param("id") int id);

}
