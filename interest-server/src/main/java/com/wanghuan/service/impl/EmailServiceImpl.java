package com.wanghuan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wanghuan.dao.EmailDao;
import com.wanghuan.model.EmailEntity;
import com.wanghuan.service.EmailService;
import com.wanghuan.utils.DateUtil;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private EmailDao emailDao;

	@Override
	public void insertEntity(EmailEntity emailEntity) {
		emailEntity.setCreatetime(DateUtil.currentTimestamp());
		emailDao.insertEntity(emailEntity);
	}

	@Override
	public List<EmailEntity> emailsList(int pageSize, int start) {
		return emailDao.emailsList(pageSize,start);
	}

	@Override
	public Integer emailsSize(int pageSize, int start) {
		return emailDao.emailsSize(pageSize,start);
	}


}
