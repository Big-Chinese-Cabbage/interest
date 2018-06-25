package com.wanghuan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wanghuan.dao.PostCardDao;
import com.wanghuan.dao.ReplyCardDao;
import com.wanghuan.model.ReplyCardEntity;
import com.wanghuan.service.ReplyCardService;
import com.wanghuan.utils.DateUtil;
import com.wanghuan.utils.SecurityAuthenUtil;

@Service
public class ReplyCardServiceImpl implements ReplyCardService {

	@Autowired
	private ReplyCardDao replyCardDao;
	
	@Autowired
	private PostCardDao postCardDao;

	@Override
	public List<ReplyCardEntity> replycardList(int postcardid, int pageSize, int start) {
		return replyCardDao.replycardList(postcardid,pageSize,start);
	}

	@Override
	public Integer replycardSize(int postcardid, int pageSize, int start) {
		return replyCardDao.replycardSize(postcardid,pageSize,start);
	}

	@Override
	public void insertEntity(ReplyCardEntity replyCardEntity) {
		replyCardEntity.setUsername(SecurityAuthenUtil.getLoginName());
		replyCardEntity.setCreatetime(DateUtil.currentTimestamp());
		
		postCardDao.updateCreatetiem(replyCardEntity.getPostcardid(),replyCardEntity.getCreatetime());
		replyCardDao.insertEntity(replyCardEntity);
	}
	
//	@Override
//	public List<PostCardEntity> postcardList(int interestid, int pageSize, int start) {
//		return replyCardDao.postcardList(interestid,pageSize,start);
//	}
//
//	@Override
//	public Integer postcardSize(int interestid, int pageSize, int start) {
//		return replyCardDao.postcardSize(interestid,pageSize,start);
//	}

//
//	@Override
//	public PostCardEntity getPostcard(int id) {
//		return replyCardDao.getPostcard(id);
//	}

}
