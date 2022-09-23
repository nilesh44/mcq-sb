package com.ace.mcq.service;

import java.util.List;

import com.ace.mcq.pojo.CreateTestRequest;
import com.ace.mcq.pojo.SuccessfullResponse;

public interface TestService {

    public SuccessfullResponse createTest(CreateTestRequest createTestRequest);
    
	public List<String> getAllTestName(String SubjectName);

}
