package com.interest.controller.template;

import com.interest.model.EmailEntity;
import com.interest.model.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.interest.service.EmailService;
import com.interest.utils.SecurityAuthenUtil;

import java.util.List;

@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;

	@GetMapping("/emails")
	public PageResult emailsList(@RequestParam("pageSize") int pageSize, @RequestParam("page") int page) {
		PageResult pageResult = new PageResult();
		pageResult.setData(emailService.emailsList(pageSize, page * pageSize));
		pageResult.setTotalCount(emailService.emailsSize(pageSize, page * pageSize));
		return pageResult;
	}

	@PostMapping("/email")
	public EmailEntity insertEntity(@RequestBody EmailEntity emailEntity) {
		emailEntity.setUsername(SecurityAuthenUtil.getLoginName());
		emailService.insertEntity(emailEntity);
		return emailEntity;
	}

	@DeleteMapping("/admin/emails")
	public List<String> deleteEmails(@RequestBody List<String> groupId) {
		emailService.deleteEmails(groupId);
		return groupId;
	}

}
