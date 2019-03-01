package com.interest.task;

import com.interest.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class MyTimingTask {

	@Autowired
	private UserDetailService userDetailService;

	/**
	 * 每日更新
	 */
	@Scheduled(cron="0 0 0 * * ?")
	public void updateViewTime() {
		userDetailService.updatedDaily();
	}

}
