package com.interest.service;

import java.util.List;

import com.interest.model.entity.ReplyCardEntity;
import com.interest.model.response.ReplyCardResponse;

public interface ReplyCardService {

	List<ReplyCardResponse> replycardList(int postcardid, int pageSize, int start);

	Integer replycardSize(int postcardid, int pageSize, int start);

	void insertEntity(ReplyCardEntity replyCardEntity);

}
