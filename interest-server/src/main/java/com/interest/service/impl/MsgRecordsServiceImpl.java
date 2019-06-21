package com.interest.service.impl;

import com.interest.dao.MsgRecordsDao;
import com.interest.model.entity.MsgRecordEntity;
import com.interest.model.utils.PageResult;
import com.interest.model.response.MsgRecordResponse;
import com.interest.service.MsgRecordsService;
import com.interest.utils.SecurityAuthenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MsgRecordsServiceImpl implements MsgRecordsService {

    @Autowired
    private MsgRecordsDao msgRecordsDao;

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Override
    public void addMsg(MsgRecordEntity entity) {
        threadPoolTaskExecutor.execute(()->{
            msgRecordsDao.addMsg(entity);
        });
    }

    @Override
    public int getUnreadMsgCount(Integer userid) {
        return msgRecordsDao.getUnreadMsgCount(userid);
    }

    @Override
    @Transactional
    public PageResult getUserMegsResult(int pageSize, int start) {
        int userid = SecurityAuthenUtil.getId();
        List<MsgRecordResponse> list = msgRecordsDao.getMsgListByUserid(userid,pageSize,start);
        int size = msgRecordsDao.getMsgSizeByUserid(userid);

        PageResult<MsgRecordResponse> pageResult = new PageResult<>();
        pageResult.setTotalCount(size);
        pageResult.setData(list);
        return pageResult;
    }

    @Override
    public void updateMsgRecordIsread(Integer msgRecordId, int isread) {
        msgRecordsDao.updateMsgRecordIsread(msgRecordId,isread);
    }
}
