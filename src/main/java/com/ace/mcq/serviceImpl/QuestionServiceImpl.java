package com.ace.mcq.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ace.mcq.entity.OptionsEntity;
import com.ace.mcq.entity.Questions;
import com.ace.mcq.pojo.GetAllQuestionResponse;
import com.ace.mcq.pojo.QuestionCreate;
import com.ace.mcq.repo.OptionsRepo;
import com.ace.mcq.repo.QuestionsRepo;
import com.ace.mcq.repo.SubjectsRepo;
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
	
	@Autowired
	private SubjectsRepo subjectRepo;

	@Autowired
	private OptionsRepo optionsRepo;
	
	@Override
	public void createQuestion(QuestionCreate questionCreate) {
		
		//validate and throw error if test not present
		Integer subjectId= validateSubjectName(questionCreate.getSubjectName());
		Integer testId = validateTestName(questionCreate.getTestName(),subjectId);

		Questions questions = Questions
				.builder()
				.question(questionCreate.getQuestion())
				.testId(testId)
				.creatTimeStamp(CommonUitilities.getSqlTimeStamp())
				.build();
		
		questionsRepo.save(questions);
		
		 log.info("question "+questionCreate.getQuestion() +" created successfully" );
	}
	

	public Integer validateSubjectName(String subjectName){
		
		Integer subjectId=subjectRepo.getSubjectByName(subjectName);
		CommonValidation.checkRecordNotFound(subjectId,subjectName+ "not present");

	    return subjectId;
	}

	public Integer validateTestName(String testName,Integer subjectId){
		
	    Integer testId = testsRepo.getTestByNameAndSubjectId(testName,subjectId);
	    CommonValidation.checkRecordNotFound(testId, "test Name not found");
	    return testId;
	}

	@Override
	public List<GetAllQuestionResponse> getAllQuestion(String testName,String subjectName) {
		
		Integer subjectId= validateSubjectName(subjectName);
		Integer testId = validateTestName(testName,subjectId);
		
	List<GetAllQuestionResponse> getAllQuestionResponse = questionsRepo.getAllQuestions(testId).stream()
		.map((question)->{
			
			List<String> options = optionsRepo.getAllOptions(testId);
			
			return GetAllQuestionResponse.builder()
			.question(question.getQuestion())
			.options(options)
			.build();
		}).collect(Collectors.toList());
		return getAllQuestionResponse;
	}
	
	

}
