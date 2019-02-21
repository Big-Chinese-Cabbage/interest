package com.interest.service.impl;

import java.io.IOException;
import java.util.List;

import com.interest.dao.InterestDao;
import com.interest.model.entity.InterestEntity;
import com.interest.model.response.BannerResponse;
import com.interest.model.response.InterestResponse;
import com.interest.properties.PathsProperties;
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
	private PathsProperties pathsProperties;

	@Override
	public List<InterestResponse> getInsterest(String title) {
		return interestDao.getInsterest(title);
	}

	@Override
	public InterestEntity getInsterestById(int id) {
		return interestDao.getInsterestById(id);
	}

	@Override
	public String savePicture(MultipartFile picture) {

		String path = "/interest/" + DateUtil.currentTimes();

		String pictureUrl = null;
		try {
			if (picture != null) {
				String fileName = ImageUtil.saveImg(picture, pathsProperties.getImage() + path);
				pictureUrl = pathsProperties.getDomainName() + path + "/" + fileName;
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
	public List<BannerResponse> getBanners() {
		return interestDao.getBanners();
	}

	@Override
	public void updateBanners(List<String> groupId, int i) {
		interestDao.updateBanners(groupId,i);
	}


}
