package com.interest.dao;

import com.interest.model.UserGithubEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserGithubDao {

	void insertEntity(UserGithubEntity userGithubEntity);
}
