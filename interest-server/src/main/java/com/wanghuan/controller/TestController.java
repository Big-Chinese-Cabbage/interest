package com.wanghuan.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping("/jwttest")
	public Object jwtTest(Authentication user) {
		return user;
	}
	
}
