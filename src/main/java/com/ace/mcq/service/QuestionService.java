package com.ace.mcq.service;

import java.util.List;

import com.ace.mcq.pojo.QuestionCreate;

public interface QuestionService {
	
	 void createQuestion(QuestionCreate questionCreate);

	 public List<String> getAllQuestion(String testName);
}
