package com.ace.mcq.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ace.mcq.entity.Tests;

@Repository
public interface TestsRepo extends JpaRepository<Tests, Integer> {

	@Query("select t.testId from Tests t where t.name = :testName and t.subjectId = :subjectId and t.expTimeStamp is null")
	Integer getTestByNameAndSubjectId(@Param("testName") String testname, @Param("subjectId") Integer subjectId);

	@Query("select t from Tests t where t.subjectId = :subjectId and  t.expTimeStamp is null")
	public List<Tests> getAllTestName(@Param("subjectId") Integer subjectId);
	
	@Query("select t.testId from Tests t where t.name = :testName and t.expTimeStamp is null")
	Integer getTestByName(@Param("testName") String testname);

}
