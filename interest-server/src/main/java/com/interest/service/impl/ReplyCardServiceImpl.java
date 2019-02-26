package com.interest.service.impl;

import java.util.List;

import com.interest.dao.PostCardDao;
import com.interest.dao.ReplyCardDao;
import com.interest.model.entity.MsgRecordEntity;
import com.interest.model.entity.ReplyCardEntity;
import com.interest.model.response.ReplyCardResponse;
import com.interest.service.MsgRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interest.service.ReplyCardService;
import com.interest.utils.DateUtil;
import com.interest.utils.SecurityAuthenUtil;

@Service
public class ReplyCardServiceImpl implements ReplyCardService {

    @Autowired
    private ReplyCardDao replyCardDao;

    @Autowired
    private PostCardDao postCardDao;

    @Autowired
    private MsgRecordsService msgRecordsService;

    @Override
    public List<ReplyCardResponse> replycardList(int postcardid, int pageSize, int start) {
        return replyCardDao.replycardList(postcardid, pageSize, start);
    }

    @Override
    public Integer replycardSize(int postcardid, int pageSize, int start) {
        return replyCardDao.replycardSize(postcardid, pageSize, start);
    }

    @Override
    public void insertEntity(ReplyCardEntity replyCardEntity) {

        //User user = SecurityAuthenUtil.getAuthenticationUser();
        //replyCardEntity.setUsername(user.getUsername());
        //replyCardEntity.setUserid(user.);

        int userid = SecurityAuthenUtil.getId();

        replyCardEntity.setUserid(userid);

        replyCardEntity.setCreatetime(DateUtil.currentTimestamp());

        postCardDao.updateCreatetiem(replyCardEntity.getPostcardid(), replyCardEntity.getCreatetime());
        replyCardDao.insertEntity(replyCardEntity);


        MsgRecordEntity msgRecordEntity = new MsgRecordEntity();
        Integer cardId = replyCardEntity.getPostcardid();
        msgRecordEntity.setOwnerid(postCardDao.getPostcard(cardId).getUserid());
        msgRecordEntity.setForm(0);
        msgRecordEntity.setReplyCardId(replyCardEntity.getId());
        msgRecordEntity.setReplytime(replyCardEntity.getCreatetime());
        msgRecordEntity.setIsread(0);

        msgRecordsService.addMsg(msgRecordEntity);

    }

}
