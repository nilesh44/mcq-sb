package com.ace.mcq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ace.mcq.pojo.OptionCreate;
import com.ace.mcq.service.OptionsService;

@RestController

public class OptionController {
	
	@Autowired
	private OptionsService optionsService;
	
	
	@PostMapping(value = "/options/create")
	public ResponseEntity<String> createOptions(@RequestBody OptionCreate optionCreate) {
		
		optionsService.createOptions(optionCreate);
		return ResponseEntity.ok().build();
	}
}
