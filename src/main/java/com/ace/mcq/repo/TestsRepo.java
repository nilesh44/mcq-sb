package com.ace.mcq.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ace.mcq.entity.Tests;

public interface TestsRepo extends JpaRepository<Tests, Integer> {

}
