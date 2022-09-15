package com.ace.mcq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ace.mcq.pojo.QuestionCreate;
import com.ace.mcq.service.QuestionService;

@RestController
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@PostMapping(value = "/question/create")
	public ResponseEntity<String> createQuestion(@RequestBody QuestionCreate questionCreate){
		
		questionService.createQuestion(questionCreate);
		
		return ResponseEntity.status(HttpStatus.OK).build();
		
	}

}
