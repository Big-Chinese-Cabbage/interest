package com.interest.service.impl;

import java.util.List;

import com.interest.dao.PostCardDao;
import com.interest.dao.ReplyCardDao;
import com.interest.model.MsgRecordEntity;
import com.interest.model.ReplyCardEntity;
import com.interest.model.view.ReplyCardModel;
import com.interest.service.MsgRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.interest.service.ReplyCardService;
import com.interest.utils.DateUtil;
import com.interest.utils.SecurityAuthenUtil;

@Service
public class ReplyCardServiceImpl implements ReplyCardService {

	@Autowired
	private ReplyCardDao replyCardDao;
	
	@Autowired
	private PostCardDao postCardDao;

	@Autowired
	private MsgRecordsService msgRecordsService;

	@Override
	public List<ReplyCardModel> replycardList(int postcardid, int pageSize, int start) {
		return replyCardDao.replycardList(postcardid,pageSize,start);
	}

	@Override
	public Integer replycardSize(int postcardid, int pageSize, int start) {
		return replyCardDao.replycardSize(postcardid,pageSize,start);
	}

	@Override
	public void insertEntity(ReplyCardEntity replyCardEntity) {

		//User user = SecurityAuthenUtil.getAuthenticationUser();
		//replyCardEntity.setUsername(user.getUsername());
		//replyCardEntity.setUserid(user.);

		int userid = SecurityAuthenUtil.getId();

		replyCardEntity.setUserid(userid);

		replyCardEntity.setCreatetime(DateUtil.currentTimestamp());
		
		postCardDao.updateCreatetiem(replyCardEntity.getPostcardid(),replyCardEntity.getCreatetime());
		replyCardDao.insertEntity(replyCardEntity);


		MsgRecordEntity msgRecordEntity = new MsgRecordEntity();
		msgRecordEntity.setReplyid(replyCardEntity.getId());

		Integer cardId = replyCardEntity.getPostcardid();
		msgRecordEntity.setCardid(cardId);

		msgRecordEntity.setOwnerid(postCardDao.getPostcard(cardId).getUserid());
		msgRecordEntity.setIsread(0);
		msgRecordEntity.setReplytime(DateUtil.currentTimestamp());

		msgRecordsService.addMsg(msgRecordEntity);

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
