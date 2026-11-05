package com.spacecoder.coding.service;

import java.util.List;

import com.spacecoder.coding.dto.TestCaseRequestDTO;
import com.spacecoder.coding.dto.TestCaseResponseDTO;

public interface TestCaseService {
  public TestCaseResponseDTO addTestCase(TestCaseRequestDTO dto);
  public TestCaseResponseDTO getTestCaseById(Long yestCaseId);
  public List<TestCaseResponseDTO> getAllTestCases();
  public void deleteTestCase(Long testCaseId);
}
