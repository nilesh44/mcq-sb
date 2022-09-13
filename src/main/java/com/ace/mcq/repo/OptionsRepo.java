package com.ace.mcq.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ace.mcq.entity.Options;

public interface OptionsRepo extends JpaRepository<Options, Integer> {

}
