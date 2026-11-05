package com.spacecoder.coding.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spacecoder.coding.entity.TestCases;

public interface TestCaseRepository extends JpaRepository<TestCases,Long>{
	 List<TestCases> findByProblem_ProbId(Long probId);
}
