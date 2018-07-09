package com.interest.service.impl;

import java.util.List;

import com.interest.dao.PostCardDao;
import com.interest.dao.ReplyCardDao;
import com.interest.model.PostCardEntity;
import com.interest.model.view.PostCardModel;
import com.interest.service.PostCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.interest.utils.DateUtil;
import com.interest.utils.SecurityAuthenUtil;

@Service
public class PostCardServiceImpl implements PostCardService {

	@Autowired
	private PostCardDao postCardDao;
	
	@Autowired
	private ReplyCardDao replyCardDao;

	@Override
	public List<PostCardModel> postcardList(String interestid, int pageSize, int start) {
		return postCardDao.postcardList(interestid,pageSize,start);
	}

	@Override
	public Integer postcardSize(String interestid, int pageSize, int start) {
		return postCardDao.postcardSize(interestid,pageSize,start);
	}

	@Override
	public void insertEntity(PostCardEntity postCardEntity) {
		postCardEntity.setUsername(SecurityAuthenUtil.getLoginName());
		postCardEntity.setCreatetime(DateUtil.currentTimestamp());
		postCardEntity.setReplytime(postCardEntity.getCreatetime());
		postCardDao.insertEntity(postCardEntity);
	}

	@Override
	public PostCardModel getPostcard(int id) {
		return postCardDao.getPostcard(id);
	}

	@Override
	@Transactional
	public void deletePostcards(List<String> groupId) {
		postCardDao.deletePostcards(groupId);
		replyCardDao.delReplyByPostcardid(groupId);
	}


}
