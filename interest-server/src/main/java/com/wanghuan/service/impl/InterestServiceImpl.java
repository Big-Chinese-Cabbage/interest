package com.wanghuan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wanghuan.dao.InterestDao;
import com.wanghuan.model.InterestEntity;
import com.wanghuan.service.InterestService;

@Service
public class InterestServiceImpl implements InterestService {

	@Autowired
	private InterestDao interestDao;

	@Override
	public List<InterestEntity> getInsterest(String title) {
		// TODO Auto-generated method stub
		return interestDao.getInsterest(title);
	}

	@Override
	public InterestEntity getInsterestById(int id) {
		// TODO Auto-generated method stub
		return interestDao.getInsterestById(id);
	}


}
