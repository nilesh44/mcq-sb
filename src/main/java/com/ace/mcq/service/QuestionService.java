package com.ace.mcq.service;

import java.util.List;

import com.ace.mcq.pojo.QuestionWithOptionsCreate;
import com.ace.mcq.pojo.FindCorrectAnswerRequest;
import com.ace.mcq.pojo.FindCorrectAnswerResponse;
import com.ace.mcq.pojo.QuestionCreate;
import com.ace.mcq.pojo.QuestionWithOptions;

public interface QuestionService {
	
	 void createQuestion(QuestionCreate questionCreate);

	 public List<QuestionWithOptions> getAllQuestion(String testName,String subjectName);

     public void createQuestionWithOptions(QuestionWithOptionsCreate questionWithOptions);

     public FindCorrectAnswerResponse findCorrectAnswer(FindCorrectAnswerRequest findCorrectAnswerRequest);
}
