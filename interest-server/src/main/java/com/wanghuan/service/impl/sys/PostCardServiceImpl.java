package com.wanghuan.service.impl.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wanghuan.dao.PostCardDao;
import com.wanghuan.dao.ReplyCardDao;
import com.wanghuan.model.sys.PostCardEntity;
import com.wanghuan.service.sys.PostCardService;
import com.wanghuan.utils.DateUtil;
import com.wanghuan.utils.SecurityAuthenUtil;

@Service
public class PostCardServiceImpl implements PostCardService {

	@Autowired
	private PostCardDao postCardDao;
	
	@Autowired
	private ReplyCardDao replyCardDao;

	@Override
	public List<PostCardEntity> postcardList(String interestid, int pageSize, int start) {
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
	public PostCardEntity getPostcard(int id) {
		return postCardDao.getPostcard(id);
	}

	@Override
	@Transactional
	public void deletePostcards(List<String> groupId) {
		postCardDao.deletePostcards(groupId);
		replyCardDao.delReplyByPostcardid(groupId);
	}


}
