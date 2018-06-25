package com.wanghuan.service;

import java.util.List;

import com.wanghuan.model.RelationEntity;

public interface RelationService {

	/**
	 * 通过userId得到关系List
	 * @param userId
	 * @return
	 */
	public List<RelationEntity> getRelationByUserId(int userId);

	/**
	 * 批量插入关系数据
	 * @param relationList
	 */
	public void insertRelations(List<RelationEntity> relationList);

	
}
