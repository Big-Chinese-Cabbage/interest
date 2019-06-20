package com.interest.service;

import com.interest.model.utils.PageResult;
import com.interest.model.request.ArticleCommentRequest;
import com.interest.model.utils.PageWrapper;

public interface ArticleCommentService {

    void putArticleCommentService(ArticleCommentRequest articleCommentRequest);

    PageResult getArticleCommentByArticleId(int articleId, PageWrapper pageWrapper);
}
