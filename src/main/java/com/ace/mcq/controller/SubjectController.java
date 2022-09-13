package com.ace.mcq.controller;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ace.mcq.pojo.SubjectCreateRequest;

@RestController
public class SubjectController {


    @PostMapping(value = "/subject/create")
    public ResponseEntity<String> createSubject(@RequestBody SubjectCreateRequest subject ){

        return ResponseEntity.ok("successfull");
    }
    
}
