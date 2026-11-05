package com.spacecoder.coding.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.spacecoder.coding.dto.TestCaseRequestDTO;
import com.spacecoder.coding.dto.TestCaseResponseDTO;
import com.spacecoder.coding.entity.Problems;
import com.spacecoder.coding.entity.TestCases;
import com.spacecoder.coding.repository.TestCaseRepository;
import com.spacecoder.coding.repository.problemRepository;

@Service
public class TestCaseServiceImpl  implements TestCaseService{

	@Autowired
	TestCaseRepository trepo;
	
	@Autowired
	problemRepository prepo;
	@Override
	public TestCaseResponseDTO addTestCase( TestCaseRequestDTO dto) {
		// TODO Auto-generated method stub
		  Problems problem = prepo.findById(dto.getProbId())
		            .orElseThrow(() -> new RuntimeException("Problem not found"));
		// Validate Test Case ID
		if (dto.getTestCaseId() == null) {
		    throw new RuntimeException("Test Case ID is required");
		}

		// Validate Problem ID
		if (dto.getProbId() == null) {
		    throw new RuntimeException("Problem ID is required");
	
		}

		// Validate Sample Input
		if (dto.getSampleInput() == null || dto.getSampleInput().isBlank()) {
		    throw new RuntimeException("Sample Input is required");
		}

		// Validate Sample Output
		if (dto.getSampleOutput() == null || dto.getSampleOutput().isBlank()) {
		    throw new RuntimeException("Sample Output is required");
		}

		// Validate Hidden Status
		if (dto.getHidden() == null) {
		    throw new RuntimeException("Hidden status is required");
		}
				if (problem == null) {
		    throw new RuntimeException("Problem not found");
		}
		TestCases testCase = new TestCases();
		testCase.setTestCaseId(dto.getTestCaseId());
		testCase.setProblem(problem);
		testCase.setSampleInput(dto.getSampleInput());
		testCase.setSampleOutput(dto.getSampleOutput());
		testCase.setIsHidden(dto.getHidden());
		TestCases savedTestCase = trepo.save(testCase);
		System.out.println("Test Case ID: " + dto.getTestCaseId());
		System.out.println("Problem ID: " + dto.getProbId());
		System.out.println("Assigned Problem ID: "
		        + testCase.getProblem().getProbId());
		return convertToDTO(savedTestCase);
		
	}

	@Override
	public TestCaseResponseDTO getTestCaseById(Long testCaseId) {
		// TODO Auto-generated method stub
		TestCases testCase = trepo.findById(testCaseId).orElse(null);

	    if (testCase == null) {
	        throw new RuntimeException("Test case not found");
	    }
	    return convertToDTO(testCase);
	}

	@Override
	public List<TestCaseResponseDTO> getAllTestCases() {
		// TODO Auto-generated method stub
		return trepo.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
	}
  
	private TestCaseResponseDTO convertToDTO(TestCases testcase) {
		 TestCaseResponseDTO dto = new TestCaseResponseDTO();
		 dto.setTestCaseId(testcase.getTestCaseId());
		 if(testcase.getProblem()!=null) {
		 dto.setProbId(testcase.getProblem().getProbId());
		 }
		 dto.setSampleInput(testcase.getSampleInput());
		    dto.setSampleOutput(testcase.getSampleOutput());
		    dto.setHidden(testcase.getIsHidden());
		    return dto;

	}

//	@Override
	public void deleteTestCase(Long testCaseId) {
		// TODO Auto-generated method stub
		trepo.deleteById(testCaseId);
	}
}
