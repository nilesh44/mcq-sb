package com.ace.mcq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ace.mcq.pojo.GetAllQuestionResponse;
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
	
	 
    @GetMapping(value = "/question/getAll/{testName}/{subjectName}")
	public ResponseEntity<List<GetAllQuestionResponse>> getAllTestName(@PathVariable("testName") String testName,
			@PathVariable("subjectName") String subjectName){		
    	List<GetAllQuestionResponse> questionsWithOptions= questionService.getAllQuestion(testName,subjectName);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(questionsWithOptions);
	}

}
