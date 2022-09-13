package com.ace.mcq.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ace.mcq.entity.Subjects;

public interface SubjectsRepo extends JpaRepository<Subjects, Integer>{

    @Query("select s.subjectId from Subjects s where s.name = :subjectname and  s.expTimeStamp is null")
    public Integer getSubjectByName(@Param("subjectname") String subjectname);

}
