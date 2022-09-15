package com.ace.mcq.service;

import java.util.List;

import com.ace.mcq.pojo.CreateTestRequest;

public interface TestService {

    public void createTest(CreateTestRequest createTestRequest);
    
	public List<String> getAllTestName(String SubjectName);

}
