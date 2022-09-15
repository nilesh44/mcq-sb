package com.ace.mcq.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ace.mcq.entity.Questions;
import com.ace.mcq.pojo.QuestionCreate;
import com.ace.mcq.repo.QuestionsRepo;
import com.ace.mcq.repo.TestsRepo;
import com.ace.mcq.service.QuestionService;
import com.ace.mcq.utilities.CommonUitilities;
import com.ace.mcq.validation.CommonValidation;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionsRepo questionsRepo;

	@Autowired
	private TestsRepo testsRepo;

	@Override
	public void createQuestion(QuestionCreate questionCreate) {
		
		//validate and throw error if test not present
		Integer testId = validateTestName(questionCreate.getTestName());

		Questions questions = Questions
				.builder()
				.question(questionCreate.getQuestion())
				.testid(testId)
				.creatTimeStamp(CommonUitilities.getSqlTimeStamp())
				.build();
		
		questionsRepo.save(questions);
		
		 log.info("question "+questionCreate.getQuestion() +" created successfully" );
	}
	
	public Integer validateTestName(String testName){
		Integer testId = testsRepo.getTestByName(testName);
	    CommonValidation.checkRecordNotFound(testId, "test Name not found");
	    return testId;
	}

}
