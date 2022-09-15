package com.ace.mcq.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ace.mcq.entity.OptionsEntity;
import com.ace.mcq.entity.Questions;
import com.ace.mcq.execption.CommonException;
import com.ace.mcq.pojo.Option;
import com.ace.mcq.pojo.OptionCreate;
import com.ace.mcq.repo.OptionsRepo;
import com.ace.mcq.repo.QuestionsRepo;
import com.ace.mcq.service.OptionsService;
import com.ace.mcq.utilities.CommonUitilities;
import com.ace.mcq.validation.CommonValidation;

import lombok.extern.slf4j.Slf4j;

@Transactional
@Service
@Slf4j
public class OptionServiceImpl implements OptionsService {

	@Autowired
	private OptionsRepo optionsRepo;

	@Autowired
	private QuestionsRepo questionsRepo;

	@Override
	public void createOptions(OptionCreate optionCreate) {

		Integer questionId=Integer.valueOf(optionCreate.getQuestionId());
		Questions question = questionsRepo.findByQuestionId(questionId);

		CommonValidation.checkRecordNotFound(question.getQuestion(), "question Not found");

		List<Option> correctOptions= optionCreate.getOptions().stream().filter((option)->
			
			option.getIsCorrect()).collect(Collectors.toList());
		
		if(correctOptions.size()!=1) {
			throw new CommonException("only one answer should correct");
		}
		List<OptionsEntity> optionsEntity = optionCreate
				.getOptions()
				.stream()
				.map((option) ->

						OptionsEntity.builder()
						.option(option.getOption())
						.isCorrect(option.getIsCorrect())
						.questionId(questionId)
					    .creatTimeStamp(CommonUitilities.getSqlTimeStamp())
					    .build())
				
				.collect(Collectors.toList());

		/*
		 * optionsEntity.forEach((option)->{ optionsRepo.save(option); });
		 */
		optionsRepo.saveAll(optionsEntity);
		
		 log.info("options  created successfully" );
	}

	@Override
	public List<String> getAllOptions(String QuestionId) {
		// TODO Auto-generated method stub
		return null;
	}

}
