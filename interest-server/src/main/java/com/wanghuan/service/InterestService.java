package com.wanghuan.service;

import java.util.List;

import com.wanghuan.model.InterestEntity;

public interface InterestService {

	public List<InterestEntity> getInsterest(String title);

	public InterestEntity getInsterestById(int id);


	
}
