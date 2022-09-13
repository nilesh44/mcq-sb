package com.ace.mcq.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ace.mcq.entity.Questions;

public interface QuestionsRepo extends JpaRepository<Questions, Integer> {

}
