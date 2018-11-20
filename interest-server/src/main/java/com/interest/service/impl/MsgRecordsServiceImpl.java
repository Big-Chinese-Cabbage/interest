package com.interest.service.impl;

import com.interest.dao.MsgRecordsDao;
import com.interest.model.MsgRecordEntity;
import com.interest.model.PageResult;
import com.interest.model.view.MsgRecordModel;
import com.interest.service.MsgRecordsService;
import com.interest.utils.SecurityAuthenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MsgRecordsServiceImpl implements MsgRecordsService {

    @Autowired
    private MsgRecordsDao msgRecordsDao;

    @Override
    public boolean addMsg(MsgRecordEntity entity) {
        msgRecordsDao.addMsg(entity);
        return false;
    }

    @Override
    public int getUnreadMsgCount(Integer userid) {
        return msgRecordsDao.getUnreadMsgCount(userid);
    }

    @Override
    @Transactional
    public PageResult getUserMegsResult(int pageSize, int start) {
        int userid = SecurityAuthenUtil.getId();
        List<MsgRecordModel> list = msgRecordsDao.getMsgListByUserid(userid,pageSize,start);
        int size = msgRecordsDao.getMsgSizeByUserid(userid);

        PageResult pageResult = new PageResult();
        pageResult.setTotalCount(size);
        pageResult.setData(list);
        return pageResult;
    }

    @Override
    public void updateMsgRecordIsread(Integer msgRecordId, int isread) {
        msgRecordsDao.updateMsgRecordIsread(msgRecordId,isread);
    }
}
