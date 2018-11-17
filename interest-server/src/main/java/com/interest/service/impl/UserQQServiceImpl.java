package com.interest.service.impl;

import com.interest.dao.UserGithubDao;
import com.interest.dao.UserQQDao;
import com.interest.model.UserGithubEntity;
import com.interest.model.UserQQEntity;
import com.interest.service.UserGithubService;
import com.interest.service.UserQQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserQQServiceImpl implements UserQQService {

	@Autowired
	private UserQQDao userQQDao;

	@Override
	public void insertEntity(UserQQEntity userQQEntity) {
		userQQDao.insertEntity(userQQEntity);
	}
}
