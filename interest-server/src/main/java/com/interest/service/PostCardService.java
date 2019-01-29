package com.interest.service;

import java.util.List;

import com.interest.model.entity.PostCardEntity;
import com.interest.model.response.PostCardResponse;

public interface PostCardService {

	List<PostCardResponse> postcardList(String interestid, int pageSize, int start);

	Integer postcardSize(String interestid, int pageSize, int start);

	void insertEntity(PostCardEntity postCardEntity);

	PostCardResponse getPostcard(int id);

	void deletePostcards(List<String> groupId);

}
