package com.interest.service;

import java.util.List;

import com.interest.model.PostCardEntity;

public interface PostCardService {

	public List<PostCardEntity> postcardList(String interestid, int pageSize, int start);

	public Integer postcardSize(String interestid, int pageSize, int start);

	public void insertEntity(PostCardEntity postCardEntity);

	public PostCardEntity getPostcard(int id);

	public void deletePostcards(List<String> groupId);

}
