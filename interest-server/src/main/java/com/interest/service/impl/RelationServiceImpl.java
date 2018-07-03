package com.interest.service.impl;

import java.util.List;

import com.interest.dao.RelationDao;
import com.interest.model.RelationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.interest.service.RelationService;

@Service(value = "relationServiceImpl")
public class RelationServiceImpl implements RelationService {

	@Autowired
	private RelationDao relationDao;

	@Override
	public List<RelationEntity> getRelationByUserId(int userId) {
		return relationDao.getRelationByUserId(userId);
	}

	@Transactional
	@Override
	public void insertRelations(List<RelationEntity> relationList) {
		relationDao.delById(relationList.get(0).getUserId());
		if (relationList.get(0).getRoleId() != null) {
			relationDao.insertRelations(relationList);
		}
	}

}
