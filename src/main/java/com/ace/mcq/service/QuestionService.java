package com.ace.mcq.service;

import java.util.List;

import com.ace.mcq.pojo.QuestionWithOptionsCreate;
import com.ace.mcq.pojo.SuccessfullResponse;
import com.ace.mcq.pojo.CreateQuestionResponse;
import com.ace.mcq.pojo.FindCorrectAnswerRequest;
import com.ace.mcq.pojo.FindCorrectAnswerResponse;
import com.ace.mcq.pojo.QuestionCreate;
import com.ace.mcq.pojo.QuestionWithOptions;

public interface QuestionService {
	
	SuccessfullResponse createQuestion(QuestionCreate questionCreate);

	 public List<QuestionWithOptions> getAllQuestion(String testName,String subjectName);

	 public QuestionWithOptions getQuestion(String QuestionId);
     public CreateQuestionResponse createQuestionWithOptions(QuestionWithOptionsCreate questionWithOptions);

     public FindCorrectAnswerResponse findCorrectAnswer(FindCorrectAnswerRequest findCorrectAnswerRequest);
}
