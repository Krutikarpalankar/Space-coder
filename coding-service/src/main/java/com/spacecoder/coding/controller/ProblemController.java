package com.spacecoder.coding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spacecoder.coding.entity.Problems;
import com.spacecoder.coding.service.ProblemsService;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/api/coding/problems")
@CrossOrigin(origins = "http://localhost:5173")
public class ProblemController {
	@Autowired
	ProblemsService pservice;
	
	@PostMapping("/add")
	public Problems addProblem(@RequestBody @Validated Problems problems) {
		return pservice.addProblem(problems);
	}
	
	@GetMapping()
	public List<Problems> getALLProblems(){
		return pservice.getAllProblem();
	}
	@DeleteMapping("/delete/{id}")
	public String  deleteProblemById(@PathVariable  Long id){
		 pservice.deleteById(id);
		 return "deleted";
	}
      
	@GetMapping("/{id}")
	public Problems getALLProblems(@PathVariable Long id){
		return pservice.getProblemById(id);
	}
	
	
	
}
