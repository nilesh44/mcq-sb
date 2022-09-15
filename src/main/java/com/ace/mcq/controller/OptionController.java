package com.ace.mcq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ace.mcq.pojo.OptionCreate;
import com.ace.mcq.service.OptionsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class OptionController {
	
	@Autowired
	private OptionsService optionsService;
	
	
	@PostMapping(value = "/options/create")
	public ResponseEntity<String> createOptions(@RequestBody OptionCreate optionCreate) {
		log.info(optionCreate.toString());
		optionsService.createOptions(optionCreate);
		return ResponseEntity.ok().build();
	}
}
