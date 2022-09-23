package com.ace.mcq.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ace.mcq.entity.Subjects;
import com.ace.mcq.pojo.SubjectCreateRequest;
import com.ace.mcq.pojo.SuccessfullResponse;
import com.ace.mcq.repo.SubjectsRepo;
import com.ace.mcq.service.SubjectService;
import com.ace.mcq.utilities.CommonUitilities;
import com.ace.mcq.validation.CommonValidation;

import lombok.extern.slf4j.Slf4j;
@Service
@Transactional
@Slf4j
public class SubjectServiceImpl implements SubjectService{
	
	@Autowired 
	private SubjectsRepo subjectsRepo;

	@Override
	public SuccessfullResponse createSubject(SubjectCreateRequest subjectCreateRequest) {
		String subjectName=subjectCreateRequest.getName();
		
		//validate and throw error if subject already present
		validateSubjectName(subjectName);
		
		Subjects subject=	Subjects.builder()
		.name(subjectName)
		.creatTimeStamp(CommonUitilities.getSqlTimeStamp())
		.build();
		
		subjectsRepo.save(subject);
		
		log.info("subject "+subjectName +" created successfully" );
		
		return SuccessfullResponse.builder().msg("subject "+subjectName+" created successfully").build();
	}
	
	private void validateSubjectName(String subjectName) {
		Integer subjectId = subjectsRepo.getSubjectByName(subjectName);
		CommonValidation.checkRecordAlreadyPresent(subjectId, subjectName + " alrady present");

	}

	@Override
	public List<String> getAllSubjectName() {
		List<String> subjectNames = subjectsRepo
				.getAllSubject()
				.stream()
				.map((subject) -> subject.getName())
				.collect(Collectors.toList());
		return subjectNames;
	}

}
