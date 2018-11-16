package com.interest.service.impl;

import com.interest.dao.UserGithubDao;
import com.interest.model.UserGithubEntity;
import com.interest.service.UserGithubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserGithubServiceImpl implements UserGithubService {

	@Autowired
	private UserGithubDao userGithubDao;

	@Override
	public void insertEntity(UserGithubEntity userGithubEntity) {
		userGithubDao.insertEntity(userGithubEntity);
	}
}
