package com.spacecoder.coding.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spacecoder.coding.entity.Problems;
import com.spacecoder.coding.repository.problemRepository;
import org.springframework.stereotype.Service;
@Service
public class ProblemsServiceImpl  implements ProblemsService{
     
	@Autowired
	problemRepository prepo;
	@Override
	public Problems addProblem(Problems problem) {
		// TODO Auto-generated method stub
		return  prepo.save(problem);
	}

	@Override
	public List<Problems> getAllProblem() {
		// TODO Auto-generated method stub
		return prepo.findAll();
	}

	@Override
	public Problems getProblemById(Long probId) {
		// TODO Auto-generated method stub
		return prepo.findById(probId).orElse(null);
	}

	@Override
	public void deleteById(Long probId) {
		// TODO Auto-generated method stub
		prepo.deleteById(probId);
	}
//
//	@Override
//	public Problems submitProblem(Long probId) {
//		// TODO Auto-generated method stub
//		return  preop.;
//	}
//
//	@Override
//	public Problems getSubmitedProblem(Long probId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
