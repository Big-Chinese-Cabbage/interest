package com.interest.controller.template;

import java.util.List;

import com.interest.model.InterestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.interest.service.InterestService;

@RestController
public class InterestController {

	@Autowired
	private InterestService interestService;

	@GetMapping("/public/interests")
	public List<InterestEntity> insterestGet(@RequestParam(value="title",required=false) String title){
		return interestService.getInsterest(title);
	}
	
	@GetMapping("/insterests/interest")
	public InterestEntity insterestGetById(@RequestParam(value="id") int id){
		return interestService.getInsterestById(id);
	}
}
