package com.interest.service;

import java.util.List;

import com.interest.model.EmailEntity;

public interface EmailService {

	public void insertEntity(EmailEntity emailEntity);

	public List<EmailEntity> emailsList(int pageSize, int start);

	public Integer emailsSize(int pageSize, int start);

    public void deleteEmails(List<String> groupId);
}
