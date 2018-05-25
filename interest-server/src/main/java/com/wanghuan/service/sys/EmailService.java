package com.wanghuan.service.sys;

import java.util.List;

import com.wanghuan.model.sys.EmailEntity;

public interface EmailService {

	public void insertEntity(EmailEntity emailEntity);

	public List<EmailEntity> emailsList(int pageSize, int start);

	public Integer emailsSize(int pageSize, int start);

	
}
