package com.interest.dao;

import com.interest.model.entity.ArticleCommentEntity;
import com.interest.model.response.ArticleCommentResponse;
import com.interest.model.response.ArticleReplyCommentResponse;
import com.interest.model.utils.PageWrapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleCommentDao {

    void insertEntity(ArticleCommentEntity articleCommentEntity);

    List<ArticleCommentResponse> getArticleCommentByArticleId(@Param("articleId") int articleId, @Param("pageWrapper") PageWrapper pageWrapper);

    List<ArticleReplyCommentResponse> getChildCommentsById(@Param("parentId") int parentId);

    int getArticleCommentSizeByArticleId(@Param("articleId") int articleId);
}
