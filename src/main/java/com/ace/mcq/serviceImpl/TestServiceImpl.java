package com.ace.mcq.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ace.mcq.entity.Tests;
import com.ace.mcq.pojo.CreateTestRequest;
import com.ace.mcq.repo.SubjectsRepo;
import com.ace.mcq.repo.TestsRepo;
import com.ace.mcq.service.TestService;
import com.ace.mcq.utilities.CommonUitilities;
import com.ace.mcq.validation.CommonValidation;
@Service
@Transactional
public class TestServiceImpl implements TestService {

    @Autowired
    private TestsRepo testsRepo;
    @Autowired
    private SubjectsRepo subjectsRepo;
    @Override
    public void createTest(CreateTestRequest createTestRequest) {
    	
        Integer subjectid= subjectsRepo.getSubjectByName(createTestRequest.getSubjectName());

        CommonValidation.checkRecordNotFound(subjectid, "subject Not Present");
        
        Tests tests= Tests.builder()
        .name(createTestRequest.getTestName())
        .subjectId(subjectid)
        .creatTimeStamp(CommonUitilities.getSqlTimeStamp())
        .build();

        testsRepo.save(tests);
        
    }
	
    
}
