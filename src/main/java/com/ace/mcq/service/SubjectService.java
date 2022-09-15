package com.ace.mcq.service;

import java.util.List;

import com.ace.mcq.pojo.SubjectCreateRequest;

public interface SubjectService {
	
	public void createSubject(SubjectCreateRequest subjectCreateRequest);
	
	public List<String> getAllSubjectName();
	
	

}
