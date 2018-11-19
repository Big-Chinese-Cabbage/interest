package com.interest.dao;

import com.interest.model.UserQQEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserQQDao {

	void insertEntity(UserQQEntity userQQEntity);
}
