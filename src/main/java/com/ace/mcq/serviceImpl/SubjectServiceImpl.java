package com.ace.mcq.serviceImpl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ace.mcq.entity.Subjects;
import com.ace.mcq.pojo.SubjectCreateRequest;
import com.ace.mcq.repo.SubjectsRepo;
import com.ace.mcq.service.SubjectService;
@Service
public class SubjectServiceImpl implements SubjectService{
	
	@Autowired 
	private SubjectsRepo subjectsRepo;

	@Override
	public void createSubject(SubjectCreateRequest subjectCreateRequest) {
		
	Subjects subject=	Subjects.builder()
		.name(subjectCreateRequest.getName())
		.creatTimeStamp(new Timestamp(System.currentTimeMillis()))
		.build();
		
		subjectsRepo.save(subject);
	}

}
