package com.ace.mcq.service;

import java.util.List;

import com.ace.mcq.pojo.OptionCreate;

public interface OptionsService {

	 void createOptions(OptionCreate optionCreate);
	
	 public List<String> getAllOptions(String QuestionId);
}
