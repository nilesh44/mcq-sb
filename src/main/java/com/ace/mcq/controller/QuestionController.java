package com.ace.mcq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ace.mcq.pojo.QuestionWithOptionsCreate;
import com.ace.mcq.pojo.SuccessfullResponse;
import com.ace.mcq.pojo.CreateQuestionResponse;
import com.ace.mcq.pojo.FindCorrectAnswerRequest;
import com.ace.mcq.pojo.FindCorrectAnswerResponse;
import com.ace.mcq.pojo.QuestionCreate;
import com.ace.mcq.pojo.QuestionWithOptions;
import com.ace.mcq.service.QuestionService;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin("http://localhost:3000/")
@Slf4j
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@PostMapping(value = "/question/create")
	public ResponseEntity<SuccessfullResponse> createQuestion(@RequestBody QuestionCreate questionCreate){
		
		
		
		return ResponseEntity.status(HttpStatus.OK).body(questionService.createQuestion(questionCreate));
		
	}
		 
    @GetMapping(value = "/question/getAll/{testName}/{subjectName}")
	public ResponseEntity<List<QuestionWithOptions>> getAllQuestion(@PathVariable("testName") String testName,
			@PathVariable("subjectName") String subjectName){		
    	List<QuestionWithOptions> questionsWithOptions= questionService.getAllQuestion(testName,subjectName);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(questionsWithOptions);
	}
    
    @GetMapping(value = "/question/{questionId}")
   	public ResponseEntity<QuestionWithOptions> getQuestion(@PathVariable("questionId") String questionId
   			){		
       	QuestionWithOptions questionsWithOptions= questionService.getQuestion(questionId);
   		return ResponseEntity
   				.status(HttpStatus.OK)
   				.body(questionsWithOptions);
   	}
      
    @PostMapping(value="/questionWithOptions/create")
    public ResponseEntity<CreateQuestionResponse> CreateQuestionWithOptions(@RequestBody QuestionWithOptionsCreate questionsWithOptions){
    	CreateQuestionResponse response=questionService.createQuestionWithOptions(questionsWithOptions);
    	log.info(response.getQuestionId());
    	return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    
    @PostMapping(value="/question/getCorrectAnswer")
    public ResponseEntity<FindCorrectAnswerResponse> findCorrectAnswer(@RequestBody FindCorrectAnswerRequest findCorrectAnswerRequest){
    	
    	return ResponseEntity
				.status(HttpStatus.OK)
				.body(questionService.findCorrectAnswer(findCorrectAnswerRequest))
				;
    }


}
