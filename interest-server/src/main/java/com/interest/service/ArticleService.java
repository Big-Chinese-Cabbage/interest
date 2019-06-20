package com.interest.service;

import com.interest.model.utils.PageResult;
import com.interest.model.request.ArticleCreateRequest;
import com.interest.model.request.ArticleUpdateRequest;
import com.interest.model.response.ArticleDetailResponse;
import com.interest.model.utils.PageWrapper;

import java.util.List;

public interface ArticleService {

	void createArticle(ArticleCreateRequest articleCreateRequest);

    PageResult getArticle(String searchContent, PageWrapper pageWrapper);

    ArticleDetailResponse getArticleById(int id);

    void addCommentCountById(Integer articleid);

    PageResult getArticlesByUserId(int userId, PageWrapper pageWrapper);

    PageResult getArticleOnManagement(String searchContent, String dateTimestamp, int del, PageWrapper pageWrapper);

    void updateArticlesDelByIds(List<String> groupId, int del);

    void updateArticlesTopByIds(List<String> groupId, int top);

    void updateArticlesDelById(int articleId);

    void updateArticle(ArticleUpdateRequest articleCreateRequest);
}
