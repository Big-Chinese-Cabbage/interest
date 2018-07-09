package com.interest.service.impl;

import java.io.IOException;
import java.util.List;

import com.interest.dao.InterestDao;
import com.interest.model.InterestEntity;
import com.interest.properties.MyProperties;
import com.interest.utils.DateUtil;
import com.interest.utils.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interest.service.InterestService;
import org.springframework.web.multipart.MultipartFile;

@Service
public class InterestServiceImpl implements InterestService {

	@Autowired
	private InterestDao interestDao;

	@Autowired
	private MyProperties myProperties;

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

	@Override
	public String savePicture(MultipartFile picture) {

		String path = "/interest/" + DateUtil.currentTimes();

		String pictureUrl = null;
		try {
			if (picture != null) {
				String fileName = ImageUtil.saveImg(picture, myProperties.getPathsProperties().getImage() + path);
				pictureUrl = myProperties.getPathsProperties().getDomainName() + path + "/" + fileName;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return pictureUrl;
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
	public List<InterestEntity> getBanners() {
		return interestDao.getBanners();
	}

	@Override
	public void updateBanners(List<String> groupId, int i) {
		interestDao.updateBanners(groupId,i);
	}


}
