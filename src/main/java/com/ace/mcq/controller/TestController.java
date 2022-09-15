package com.ace.mcq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ace.mcq.pojo.CreateTestRequest;
import com.ace.mcq.service.TestService;

@RestController
public class TestController {
    

    @Autowired
    private TestService testService;

    @PostMapping(value="/test/create")
    public ResponseEntity<String> createTest(@RequestBody CreateTestRequest createTestRequest){
        testService.createTest(createTestRequest);
        return ResponseEntity.ok().build();

    }
    
    @GetMapping(value = "/test/getAll/{subjectName}")
	public ResponseEntity<List<String>> getAllTestName(@PathVariable("subjectName") String subjectName){		
		List<String> testName= testService.getAllTestName(subjectName);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(testName);
	}
}
