package com.interest.service.impl;

import com.interest.dao.InterestDao;
import com.interest.model.entity.InterestEntity;
import com.interest.model.response.BannerResponse;
import com.interest.model.response.InterestResponse;
import com.interest.service.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterestServiceImpl implements InterestService {

	@Autowired
	private InterestDao interestDao;

	@Override
	public List<InterestResponse> getInsterest(String title) {
		return interestDao.getInsterest(title);
	}

	@Override
	public InterestEntity getInsterestById(int id) {
		return interestDao.getInsterestById(id);
	}

	@Override
	public void insertEntity(InterestEntity interestEntity) {
		interestDao.insertEntity(interestEntity);
	}

	@Override
	public void updateEntity(InterestEntity interestEntity) {
		interestDao.updateEntity(interestEntity);
	}

	@Override
	public List<InterestEntity> interestList(int pageSize, int start) {
		return interestDao.interestList(pageSize,start);
	}

	@Override
	public Integer interestSize() {
		return interestDao.interestSize();
	}

	@Override
	public void deleteInterests(List<String> groupId) {
		interestDao.deleteInterests(groupId);
	}

	@Override
	public List<BannerResponse> getBanners() {
		return interestDao.getBanners();
	}

	@Override
	public void updateBanners(List<String> groupId, int i) {
		interestDao.updateBanners(groupId,i);
	}


}
