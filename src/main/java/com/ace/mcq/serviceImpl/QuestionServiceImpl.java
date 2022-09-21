package com.ace.mcq.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ace.mcq.entity.OptionsEntity;
import com.ace.mcq.entity.Questions;
import com.ace.mcq.execption.CommonException;
import com.ace.mcq.pojo.QuestionWithOptionsCreate;
import com.ace.mcq.pojo.FindCorrectAnswerRequest;
import com.ace.mcq.pojo.FindCorrectAnswerResponse;
import com.ace.mcq.pojo.Option;
import com.ace.mcq.pojo.OptionResonse;
import com.ace.mcq.pojo.QuestionCreate;
import com.ace.mcq.pojo.QuestionWithOptions;
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
	public List<QuestionWithOptions> getAllQuestion(String testName,String subjectName) {
		
		Integer subjectId= validateSubjectName(subjectName);
		Integer testId = validateTestName(testName,subjectId);
		
	List<QuestionWithOptions> getAllQuestionResponse = questionsRepo.getAllQuestions(testId).stream()
		.map((question)->{
			
			List<OptionsEntity> options = optionsRepo.getAllOptions(question.getQuestionId());
			
			List<OptionResonse> optionResponse=	options.stream().map((option)->{
				return OptionResonse.builder().optionId(option.getOptionId().toString())
				.option(option.getOption()).build();
			}).collect(Collectors.toList());
			return QuestionWithOptions.builder()
			.question(question.getQuestion())
			.questionId(question.getQuestionId().toString())
			.options(optionResponse)
			.build();
		}).collect(Collectors.toList());
		return getAllQuestionResponse;
	}


	@Override
	public void createQuestionWithOptions(QuestionWithOptionsCreate questionWithOptions) {
		
		validateOptions(questionWithOptions.getOptions());
		Integer subjectId = validateSubjectName(questionWithOptions.getSubjectName());
		Integer testId = validateTestName(questionWithOptions.getTestName(), subjectId);

		//create question
		Questions questions = Questions
				.builder()
				.question(questionWithOptions.getQuestion())
				.testId(testId)
				.creatTimeStamp(CommonUitilities.getSqlTimeStamp())
				.build();
		
		Questions returnQuestion= questionsRepo.save(questions);
		
		
		
		
	
	
	//create options
	List<OptionsEntity> optionsEntity = questionWithOptions
			.getOptions()
			.stream()
			.map((option) ->

					OptionsEntity.builder()
					.option(option.getOption())
					.isCorrect(option.getIsCorrect())
					.questionId(returnQuestion.getQuestionId())
				    .creatTimeStamp(CommonUitilities.getSqlTimeStamp())
				    .build())
			
			.collect(Collectors.toList());

	/*
	 * optionsEntity.forEach((option)->{ optionsRepo.save(option); });
	 */
	optionsRepo.saveAll(optionsEntity);
	
	}
	
	



private void validateOptions( List<Option> options) {
	List<Option> correctOptions= options
			.stream()
			.filter((option)->
	
	option.getIsCorrect()).collect(Collectors.toList());

if(correctOptions.size()!=1) {
	throw new CommonException("only one answer should correct");
}
}


@Override
public FindCorrectAnswerResponse findCorrectAnswer(FindCorrectAnswerRequest findCorrectAnswerRequest) {
	OptionsEntity option= optionsRepo.findCorrectAnswer(findCorrectAnswerRequest.getQuestionId());
	
	if(option!=null && option.getOptionId()==findCorrectAnswerRequest.getOptionId()) {
		return FindCorrectAnswerResponse.builder().msg("correct Answer").build();
	}
	return FindCorrectAnswerResponse.builder().msg("Incorrect answer").build();
}
}