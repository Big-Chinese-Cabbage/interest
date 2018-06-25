package com.wanghuan.service;

import java.util.List;

import com.wanghuan.model.EmailEntity;

public interface EmailService {

	public void insertEntity(EmailEntity emailEntity);

	public List<EmailEntity> emailsList(int pageSize, int start);

	public Integer emailsSize(int pageSize, int start);

	
}
