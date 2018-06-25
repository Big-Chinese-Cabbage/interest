package com.wanghuan.controller.template;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wanghuan.model.InterestEntity;
import com.wanghuan.service.InterestService;

@RestController
public class InterestController {

	@Autowired
	private InterestService interestService;

	@GetMapping("/insterests")
	public List<InterestEntity> insterestGet(@RequestParam(value="title",required=false) String title){
		return interestService.getInsterest(title);
	}
	
	@GetMapping("/insterests/insterest")
	public InterestEntity insterestGetById(@RequestParam(value="id") int id){
		return interestService.getInsterestById(id);
	}
}
