package com.ace.mcq.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ace.mcq.entity.OptionsEntity;
import com.ace.mcq.entity.Questions;
import com.ace.mcq.pojo.OptionCreate;
import com.ace.mcq.repo.OptionsRepo;
import com.ace.mcq.repo.QuestionsRepo;
import com.ace.mcq.service.OptionsService;
import com.ace.mcq.utilities.CommonUitilities;
import com.ace.mcq.validation.CommonValidation;

@Transactional
@Service
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

		List<OptionsEntity> optionsEntity = optionCreate
				.getOptions()
				.stream()
				.map((option) ->

						OptionsEntity.builder()
						.option(option.getOption())
						.isCorrect(option.isCorrect())
						.questionId(questionId)
					    .creatTimeStamp(CommonUitilities.getSqlTimeStamp())
					    .build())
				
				.collect(Collectors.toList());

		optionsEntity.forEach((option)->{
			optionsRepo.save(option);
		});
		//optionsRepo.saveAll(options);
	}

}
