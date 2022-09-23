package com.ace.mcq.service;

import java.util.List;

import com.ace.mcq.pojo.SubjectCreateRequest;
import com.ace.mcq.pojo.SuccessfullResponse;

public interface SubjectService {
	
	public SuccessfullResponse createSubject(SubjectCreateRequest subjectCreateRequest);
	
	public List<String> getAllSubjectName();
	
	

}
