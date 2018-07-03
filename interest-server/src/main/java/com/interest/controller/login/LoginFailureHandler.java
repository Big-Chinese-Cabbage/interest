package com.interest.controller.login;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class LoginFailureHandler {

	@ExceptionHandler(LoginFailureExcepiton.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public Map<String, Object> handleLoginFailureExcepiton(LoginFailureExcepiton ex) {
		Map<String,Object> result = new HashMap<>();
		result.put("message", ex.getMessage());
		result.put("error type", "登陆失败");
		return result;
	}

}
