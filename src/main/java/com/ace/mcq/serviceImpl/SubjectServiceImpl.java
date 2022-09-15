package com.ace.mcq.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ace.mcq.entity.Subjects;
import com.ace.mcq.pojo.SubjectCreateRequest;
import com.ace.mcq.repo.SubjectsRepo;
import com.ace.mcq.service.SubjectService;
import com.ace.mcq.utilities.CommonUitilities;
@Service
@Transactional
public class SubjectServiceImpl implements SubjectService{
	
	@Autowired 
	private SubjectsRepo subjectsRepo;

	@Override
	public void createSubject(SubjectCreateRequest subjectCreateRequest) {
		
	Subjects subject=	Subjects.builder()
		.name(subjectCreateRequest.getName())
		.creatTimeStamp(CommonUitilities.getSqlTimeStamp())
		.build();
		
		subjectsRepo.save(subject);
	}

}
