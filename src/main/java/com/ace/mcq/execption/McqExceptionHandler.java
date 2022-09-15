package com.ace.mcq.execption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ace.mcq.pojo.Error;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class McqExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<Error> handleNotHandleException(Exception e){
		log.error(e.getLocalizedMessage());
		return ResponseEntity
				.badRequest()
				.body(Error.builder().msg(e.getMessage())
			    .build());
	}

	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<Error> handleRecordNotFoundException(Exception e){
		log.error(e.getLocalizedMessage());
		return ResponseEntity
		.status(HttpStatus.NOT_FOUND)
		.body(Error.builder().msg(e.getMessage()).build());

	}
	
	@ExceptionHandler(RecordAlradyPresentException.class)
	public ResponseEntity<Error> handleRecordAlradyPresentException(Exception e){
		log.error(e.getLocalizedMessage());
		return ResponseEntity
		.status(HttpStatus.BAD_REQUEST)
		.body(Error.builder().msg(e.getMessage()).build());
	}

}
