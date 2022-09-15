package com.ace.mcq.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ace.mcq.entity.Tests;
@Repository
public interface TestsRepo extends JpaRepository<Tests, Integer> {
	
	@Query("select t.testId from Tests t where t.name = :testName and t.expTimeStamp is null")
	Integer getTestByName(@Param("testName") String testname);

}
