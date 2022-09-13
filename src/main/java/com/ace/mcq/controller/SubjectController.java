package com.ace.mcq.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubjectController {


    @PostMapping(value = "/subject/create")
    public ResponseEntity<String> createSubject(){

        return ResponseEntity.ok("successfull");
    }
    
}
