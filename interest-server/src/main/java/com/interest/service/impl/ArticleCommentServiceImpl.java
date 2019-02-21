package com.interest.service.impl;

import com.interest.dao.ArticleCommentDao;
import com.interest.dao.ArticleDao;
import com.interest.exception.ArticleException;
import com.interest.model.entity.ArticleCommentEntity;
import com.interest.model.entity.ArticleEntity;
import com.interest.model.entity.PageResult;
import com.interest.model.entity.UserDetailEntity;
import com.interest.model.request.ArticleCommentRequest;
import com.interest.model.request.ArticleCreateRequest;
import com.interest.model.response.ArticleCommentResponse;
import com.interest.model.response.ArticleDetailResponse;
import com.interest.model.response.ArticleResponse;
import com.interest.model.utils.PageWrapper;
import com.interest.model.utils.ResponseStatus;
import com.interest.service.ArticleCommentService;
import com.interest.service.ArticleService;
import com.interest.service.UserDetailService;
import com.interest.utils.DateUtil;
import com.interest.utils.SecurityAuthenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class ArticleCommentServiceImpl implements ArticleCommentService {

    @Autowired
    private ArticleCommentDao articleCommentDao;

    @Autowired
    private ArticleService articleService;

    @Override
    public void putArticleCommentService(ArticleCommentRequest articleCommentRequest) {

        int userId = SecurityAuthenUtil.getId();

        ArticleCommentEntity articleCommentEntity = new ArticleCommentEntity();
        articleCommentEntity.setArticleid(articleCommentRequest.getArticleid());
        articleCommentEntity.setUserid(userId);
        articleCommentEntity.setParentid(articleCommentRequest.getParentid());
        articleCommentEntity.setComment(articleCommentRequest.getComment());
        articleCommentEntity.setCreateTime(DateUtil.currentTimestamp());
        articleCommentEntity.setReplierId(articleCommentRequest.getReplierId());
        articleCommentEntity.setReplierName(articleCommentRequest.getReplierName());

        articleCommentDao.insertEntity(articleCommentEntity);

        articleService.addCommentCountById(articleCommentEntity.getArticleid());

    }

    @Override
    public PageResult getArticleCommentByArticleId(int articleId, PageWrapper pageWrapper) {
        List<ArticleCommentResponse> list = articleCommentDao.getArticleCommentByArticleId(articleId,pageWrapper);
        int size = articleCommentDao.getArticleCommentSizeByArticleId(articleId);

        return new PageResult(list,size);
    }
}
