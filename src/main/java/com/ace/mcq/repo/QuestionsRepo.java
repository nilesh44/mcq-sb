package com.ace.mcq.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ace.mcq.entity.Questions;
@Repository
public interface QuestionsRepo extends JpaRepository<Questions, Integer> {

	@Query("select q from Questions q where q.questionId = :questionId and q.expTimeStamp is null")
	public Questions findByQuestionId(@Param("questionId") Integer questionId);
}
