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

import lombok.extern.slf4j.Slf4j;
@Service
@Transactional
@Slf4j
public class TestServiceImpl implements TestService {

    @Autowired
    private TestsRepo testsRepo;
    @Autowired
    private SubjectsRepo subjectsRepo;
    @Override
    public void createTest(CreateTestRequest createTestRequest) {
    	
    	//validate and throw error if subject not present
    	Integer subjectid = validateSubject(createTestRequest.getSubjectName());
        
    	String testName=createTestRequest.getTestName();
        //validate and throw error if testName already Present.    	 
        validateTest(testName);
        
        Tests tests= Tests.builder()
        .name(testName)
        .subjectId(subjectid)
        .creatTimeStamp(CommonUitilities.getSqlTimeStamp())
        .build();

        testsRepo.save(tests);
        
        log.info("test "+testName +" created successfully" );
    }
    
    private Integer validateSubject(String subjectName) {
    	Integer subjectid= subjectsRepo.getSubjectByName(subjectName);

        CommonValidation.checkRecordNotFound(subjectid, "subject Not Present");
        return subjectid;
    }
    
    private Integer validateTest(String testName) {
    	 Integer testId= testsRepo.getTestByName(testName);
         CommonValidation.checkRecordAlreadyPresent(testId, testName+ " alrady prsesent");
    return testId;
    }
	
    
}
