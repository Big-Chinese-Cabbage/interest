package com.interest.dao;

import com.interest.model.entity.ArticleEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleDao {

    void insertArticle(ArticleEntity articleEntity);
}
