package com.ace.mcq.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ace.mcq.entity.Subjects;

public interface SubjectsRepo extends JpaRepository<Subjects, Integer>{

}
