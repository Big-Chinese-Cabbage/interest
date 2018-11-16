package com.interest.service.impl;

import com.interest.dao.MsgRecordsDao;
import com.interest.model.MsgRecordEntity;
import com.interest.service.MsgRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MsgRecordsServiceImpl implements MsgRecordsService {

    @Autowired
    private MsgRecordsDao msgRecordsDao;

    @Override
    public boolean addMsg(MsgRecordEntity entity) {
        msgRecordsDao.addMsg(entity);
        return false;
    }
}
