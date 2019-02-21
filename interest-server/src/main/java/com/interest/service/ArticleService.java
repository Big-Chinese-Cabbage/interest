package com.interest.service;

import com.interest.model.entity.PageResult;
import com.interest.model.request.ArticleCreateRequest;
import com.interest.model.response.ArticleDetailResponse;
import com.interest.model.utils.PageWrapper;

public interface ArticleService {

	void createArticle(ArticleCreateRequest articleCreateRequest);

    PageResult getArticle(String searchContent, PageWrapper pageWrapper);

    ArticleDetailResponse getArticleById(int id);

    void addCommentCountById(Integer articleid);
}
