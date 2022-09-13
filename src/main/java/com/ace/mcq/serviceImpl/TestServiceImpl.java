package com.ace.mcq.serviceImpl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ace.mcq.entity.Tests;
import com.ace.mcq.execption.RecordNotFoundException;
import com.ace.mcq.pojo.CreateTestRequest;
import com.ace.mcq.repo.SubjectsRepo;
import com.ace.mcq.repo.TestsRepo;
import com.ace.mcq.service.TestService;
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestsRepo testsRepo;
    @Autowired
    private SubjectsRepo subjectsRepo;
    @Override
    public void createTest(CreateTestRequest createTestRequest) {
        Integer subjectid= subjectsRepo.getSubjectByName(createTestRequest.getSubjectName());

        if(subjectid==null){
            //throw error
            throw new RecordNotFoundException("subject Not Present");
        }
        Tests tests= Tests.builder()
        .name(createTestRequest.getTestName())
        .subjectId(subjectid)
        .creatTimeStamp(new Timestamp(System.currentTimeMillis()))
        .build();

        testsRepo.save(tests);
        
    }
    
}
