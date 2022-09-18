package com.ace.mcq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ace.mcq.pojo.SubjectCreateRequest;
import com.ace.mcq.service.SubjectService;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin("http://localhost:3000/")
public class SubjectController {

	@Autowired
	SubjectService subjectService;
	
	@PostMapping(value = "/subject/create")
	public ResponseEntity<String> createSubject(@RequestBody SubjectCreateRequest subject) {	
		subjectService.createSubject(subject);
		return ResponseEntity.ok("successfull");
	}
	
	@GetMapping(value = "/subject/getAll")
	public ResponseEntity<List<String>> getAllSubject(){		
		List<String> subjectNames= subjectService.getAllSubjectName();
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(subjectNames);
	}

}
