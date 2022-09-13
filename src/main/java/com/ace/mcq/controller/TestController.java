package com.ace.mcq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ace.mcq.pojo.CreateTestRequest;
import com.ace.mcq.service.TestService;

@RestController
public class TestController {
    

    @Autowired
    private TestService testService;

    @PostMapping
    public ResponseEntity<String> createTest(@RequestBody CreateTestRequest createTestRequest){
        testService.createTest(createTestRequest);
        return ResponseEntity.ok().build();

    }
}
