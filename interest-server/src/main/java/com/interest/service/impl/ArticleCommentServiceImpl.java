package com.interest.service.impl;

import com.interest.dao.ArticleCommentDao;
import com.interest.model.entity.*;
import com.interest.model.request.ArticleCommentRequest;
import com.interest.model.response.ArticleCommentResponse;
import com.interest.model.utils.PageResult;
import com.interest.model.utils.PageWrapper;
import com.interest.service.ArticleCommentService;
import com.interest.service.ArticleService;
import com.interest.service.MsgRecordsService;
import com.interest.utils.DateUtil;
import com.interest.utils.SecurityAuthenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleCommentServiceImpl implements ArticleCommentService {

    @Autowired
    private ArticleCommentDao articleCommentDao;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private MsgRecordsService msgRecordsService;

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

        MsgRecordEntity msgRecordEntity = new MsgRecordEntity();
        msgRecordEntity.setOwnerid(articleCommentRequest.getArticleOwnerId());
        msgRecordEntity.setForm(1);
        msgRecordEntity.setCommentId(articleCommentEntity.getId());
        msgRecordEntity.setReplytime(articleCommentEntity.getCreateTime());
        msgRecordEntity.setIsread(0);
        msgRecordsService.addMsg(msgRecordEntity);
        if(articleCommentRequest.getReplierId() != null){
            MsgRecordEntity commentMsgRecordEntity = new MsgRecordEntity();
            commentMsgRecordEntity.setOwnerid(articleCommentRequest.getReplierId());
            commentMsgRecordEntity.setForm(1);
            commentMsgRecordEntity.setCommentId(articleCommentEntity.getId());
            commentMsgRecordEntity.setReplytime(articleCommentEntity.getCreateTime());
            commentMsgRecordEntity.setIsread(0);
            msgRecordsService.addMsg(commentMsgRecordEntity);
        }

    }

    @Override
    public PageResult getArticleCommentByArticleId(int articleId, PageWrapper pageWrapper) {
        List<ArticleCommentResponse> list = articleCommentDao.getArticleCommentByArticleId(articleId,pageWrapper);
        int size = articleCommentDao.getArticleCommentSizeByArticleId(articleId);

        return new PageResult<>(list,size);
    }
}
