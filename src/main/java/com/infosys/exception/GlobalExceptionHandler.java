package com.infosys.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(InfyRailException.class)
	public Map<String,String>routeIdNotFoundException(InfyRailException ex){
		Map<String,String> errorMap= new HashMap<String, String>();
		
		errorMap.put("Error Message", ex.getMessage());
		return errorMap;
		
	}
}
