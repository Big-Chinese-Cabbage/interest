package com.wanghuan.service.sys;

import java.util.List;

import com.wanghuan.model.sys.InterestEntity;

public interface InterestService {

	public List<InterestEntity> getInsterest(String title);

	public InterestEntity getInsterestById(int id);


	
}
