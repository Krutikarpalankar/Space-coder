package com.spacecoder.coding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.spacecoder.coding.dto.TestCaseRequestDTO;
import com.spacecoder.coding.dto.TestCaseResponseDTO;
import com.spacecoder.coding.service.TestCaseService;

@RestController
@RequestMapping("/api/coding/testcases")
@CrossOrigin(origins = "http://localhost:5173")
public class TestCaseController {

    @Autowired
    TestCaseService testCaseService;

    // Add a test case
    @PostMapping("/add")
    public TestCaseResponseDTO addTestCase(@RequestBody TestCaseRequestDTO dto) {
        return testCaseService.addTestCase(dto);
    }

    // Get test case by ID
    @GetMapping("/{id}")
    public TestCaseResponseDTO getTestCaseById(@PathVariable Long id) {
        return testCaseService.getTestCaseById(id);
    }

    // Get all test cases
    @GetMapping
    public List<TestCaseResponseDTO> getAllTestCases() {
        return testCaseService.getAllTestCases();
    }
    @DeleteMapping("/{id}")
    public String deleteTestCase(@PathVariable Long id) {
        testCaseService.deleteTestCase(id);
        return "Test case deleted successfully";
    }
}