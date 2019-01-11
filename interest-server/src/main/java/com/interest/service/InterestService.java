package com.interest.service;

import java.util.List;

import com.interest.model.InterestEntity;
import org.springframework.web.multipart.MultipartFile;

public interface InterestService {

	List<InterestEntity> getInsterest(String title);

	InterestEntity getInsterestById(int id);

    String savePicture(MultipartFile picture);

	void insertEntity(InterestEntity interestEntity);

	void updateEntity(InterestEntity interestEntity);

	List<InterestEntity> interestList(int pageSize, int start);

	Integer interestSize();

	void deleteInterests(List<String> groupId);

    List<InterestEntity> getBanners();

	void updateBanners(List<String> groupId, int i);
}
