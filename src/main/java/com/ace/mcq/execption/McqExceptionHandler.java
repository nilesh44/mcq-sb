package com.ace.mcq.execption;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ace.mcq.pojo.Error;

@ControllerAdvice
public class McqExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<Error> handleNotHandleException(Exception e){
		
		return ResponseEntity
				.badRequest()
				.body(Error.builder().msg(e.getMessage())
			    .build());
	}

}
