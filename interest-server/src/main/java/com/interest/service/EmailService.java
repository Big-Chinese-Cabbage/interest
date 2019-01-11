package com.interest.service;

import java.util.List;

import com.interest.model.EmailEntity;

public interface EmailService {

	void insertEntity(EmailEntity emailEntity);

	List<EmailEntity> emailsList(int pageSize, int start);

	Integer emailsSize(int pageSize, int start);

    void deleteEmails(List<String> groupId);
}
