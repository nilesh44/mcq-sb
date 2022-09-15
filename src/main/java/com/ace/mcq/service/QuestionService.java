package com.ace.mcq.service;

import java.util.List;

import com.ace.mcq.pojo.GetAllQuestionResponse;
import com.ace.mcq.pojo.QuestionCreate;

public interface QuestionService {
	
	 void createQuestion(QuestionCreate questionCreate);

	 public List<GetAllQuestionResponse> getAllQuestion(String testName,String subjectName);
}
