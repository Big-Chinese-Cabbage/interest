package com.interest.exception.handler;

import com.interest.exception.ArticleException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@ResponseBody
public class MyExceptionHandler {

	@ExceptionHandler(ArticleException.class)
	@ResponseStatus(HttpStatus.OK)
	public Map<String, Object> handlerArticleException(ArticleException ex) {
		Map<String,Object> result = new HashMap<>();
		result.put("status", ex.getCode());
		result.put("message", ex.getMessage());
		result.put("error", ex.toString());
		return result;
	}

	
}
