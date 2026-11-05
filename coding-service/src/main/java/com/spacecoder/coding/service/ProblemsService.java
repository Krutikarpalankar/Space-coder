package com.spacecoder.coding.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spacecoder.coding.entity.Problems;
import com.spacecoder.coding.repository.problemRepository;

public interface ProblemsService {

	
	
	public Problems addProblem(Problems problem);
    public List<Problems>getAllProblem();
    public Problems getProblemById(Long probId);
    public void deleteById(Long probId);
//    public Problems submitProblem(Long probId);
//    public Problems getSubmitedProblem(Long probId);
}