package com.ace.mcq.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ace.mcq.entity.OptionsEntity;
@Repository
public interface OptionsRepo extends JpaRepository<OptionsEntity, Integer> {

}
