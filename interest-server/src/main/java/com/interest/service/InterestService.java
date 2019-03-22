package com.interest.service;

import java.util.List;

import com.interest.model.entity.InterestEntity;
import com.interest.model.response.BannerResponse;
import com.interest.model.response.InterestResponse;
import org.springframework.web.multipart.MultipartFile;

public interface InterestService {

	List<InterestResponse> getInsterest(String title);

	InterestEntity getInsterestById(int id);

	void insertEntity(InterestEntity interestEntity);

	void updateEntity(InterestEntity interestEntity);

	List<InterestEntity> interestList(int pageSize, int start);

	Integer interestSize();

	void deleteInterests(List<String> groupId);

    List<BannerResponse> getBanners();

	void updateBanners(List<String> groupId, int i);
}
