package com.interest.service;

import java.util.List;

import com.interest.model.InterestEntity;

public interface InterestService {

	public List<InterestEntity> getInsterest(String title);

	public InterestEntity getInsterestById(int id);


	
}
