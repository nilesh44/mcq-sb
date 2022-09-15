package com.ace.mcq.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ace.mcq.entity.Subjects;
@Repository
public interface SubjectsRepo extends JpaRepository<Subjects, Integer>{

    @Query("select s.subjectId from Subjects s where s.name = :subjectname and  s.expTimeStamp is null")
    public Integer getSubjectByName(@Param("subjectname") String subjectname);
    
    @Query("select s from Subjects s where s.expTimeStamp is null")
    public List<Subjects> getAllSubject();

}
