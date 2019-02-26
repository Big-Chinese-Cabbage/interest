package com.interest.dao;

import com.interest.model.entity.ArticleEntity;
import com.interest.model.response.ArticleDetailResponse;
import com.interest.model.response.ArticleResponse;
import com.interest.model.utils.PageWrapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleDao {

    void insertArticle(ArticleEntity articleEntity);

    List<ArticleResponse> getArticleList(@Param("searchContent") String searchContent,@Param("pageWrapper") PageWrapper pageWrapper);

    Integer getArticleSize(@Param("searchContent") String searchContent);

    ArticleDetailResponse getArticleById(@Param("id") int id);

    void addClickRateById(@Param("number") int number,@Param("id") int id);

    void addCommentCountById(@Param("number") int number,@Param("id") Integer articleid);

    List<ArticleResponse> getArticlesListByUserId(@Param("userId")int userId,@Param("pageWrapper") PageWrapper pageWrapper);

    Integer getArticlesSizeByUserId(@Param("userId")int userId);
}
