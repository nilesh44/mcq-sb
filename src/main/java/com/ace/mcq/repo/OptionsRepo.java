package com.ace.mcq.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ace.mcq.entity.OptionsEntity;
import com.ace.mcq.entity.Questions;
@Repository
public interface OptionsRepo extends JpaRepository<OptionsEntity, Integer> {

	
	@Query("select o.option from OptionsEntity o where o.questionId = :questionId and  o.expTimeStamp is null")
	public List<String> getAllOptions(@Param("questionId") Integer questionId);
}
