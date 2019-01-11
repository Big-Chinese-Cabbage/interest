package com.interest.service;

import java.util.List;

import com.interest.model.ReplyCardEntity;
import com.interest.model.view.ReplyCardModel;

public interface ReplyCardService {

	List<ReplyCardModel> replycardList(int postcardid, int pageSize, int start);

	Integer replycardSize(int postcardid, int pageSize, int start);

	void insertEntity(ReplyCardEntity replyCardEntity);

}
