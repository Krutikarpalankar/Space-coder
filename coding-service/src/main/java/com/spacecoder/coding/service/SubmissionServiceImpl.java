package com.spacecoder.coding.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spacecoder.coding.entity.TestCases;
import com.spacecoder.coding.dto.SubmissionRequestDTO;
import com.spacecoder.coding.dto.SubmissionResponseDTO;
import com.spacecoder.coding.entity.Problems;
import com.spacecoder.coding.entity.Submissions;
import com.spacecoder.coding.repository.SubmissionRepository;
import com.spacecoder.coding.repository.TestCaseRepository;
import com.spacecoder.coding.repository.problemRepository;
import com.spacecoder.coding.dto.Judge0RequestDTO;
import com.spacecoder.coding.dto.Judge0ResponseDTO;
import java.time.LocalDateTime;

@Service
public class SubmissionServiceImpl implements SubmissionService {

    @Autowired
    SubmissionRepository srepo;

    @Autowired
    problemRepository prepo;
    @Autowired
    CodeExecutionService codeExecutionService;
    @Autowired
    TestCaseRepository trepo;
    private void validateLanguage(String language) {

        if (language == null ||
            !(language.equalsIgnoreCase("JAVA") ||
              language.equalsIgnoreCase("PYTHON") ||
              language.equalsIgnoreCase("CPP"))) {

            throw new RuntimeException("Unsupported programming language");
        }
    }

    
    @Override
    public SubmissionResponseDTO saveSubmission(SubmissionRequestDTO dto) {

        Problems problem = prepo.findById(dto.getProbId()).orElse(null);

        if (problem == null) {
            throw new RuntimeException("Problem not found");
        }

        validateLanguage(dto.getLanguage());

        Submissions submission = new Submissions();

        submission.setSubmissionId(dto.getSubmissionId());
        submission.setUserId(dto.getUserId());
        submission.setProblem(problem);
        submission.setSourceCode(dto.getSourceCode());
        submission.setLanguage(dto.getLanguage());
        submission.setSubmissionStatus("PENDING");

        submission.setSubmittedAt(LocalDateTime.now());

        System.out.println("========== TIMESTAMP DEBUG ==========");
        System.out.println("Before save: " + submission.getSubmittedAt());

        Submissions savedSubmission = srepo.save(submission);

        System.out.println("After save: " + savedSubmission.getSubmittedAt());
        System.out.println("=====================================");
        
        List<TestCases> testCases =
                trepo.findByProblem_ProbId(dto.getProbId());

        if (testCases.isEmpty()) {
            throw new RuntimeException("No test cases found for this problem");
        }

        boolean allPassed = true;

        for (TestCases testCase : testCases) {

            Judge0RequestDTO judgeRequest = new Judge0RequestDTO();

            judgeRequest.setSource_code(dto.getSourceCode());
            judgeRequest.setLanguage_id(getLanguageId(dto.getLanguage()));
            judgeRequest.setStdin(testCase.getSampleInput());

            // Execute code only once
            Judge0ResponseDTO judgeResponse =
                    codeExecutionService.executeCode(judgeRequest);
            System.out.println("========== JUDGE0 DEBUG ==========");
            System.out.println("Test Case ID: " + testCase.getTestCaseId());
            System.out.println("Input: " + testCase.getSampleInput());
            System.out.println("Expected: " + testCase.getSampleOutput());

            if (judgeResponse != null && judgeResponse.getStatus() != null) {
                System.out.println("Status ID: " + judgeResponse.getStatus().getId());
                System.out.println("Status: " + judgeResponse.getStatus().getDescription());
                System.out.println("Actual Output: " + judgeResponse.getStdout());
                System.out.println("Compile Output: " + judgeResponse.getCompile_output());
                System.out.println("Stderr: " + judgeResponse.getStderr());
                System.out.println("Time: " + judgeResponse.getTime());
                System.out.println("Memory: " + judgeResponse.getMemory());
            }

            System.out.println("=================================");
            if (judgeResponse == null || judgeResponse.getStatus() == null) {
                submission.setSubmissionStatus("Execution Error");
                allPassed = false;
                break;
            }

            // Save execution time and memory
            submission.setExecutionTime(judgeResponse.getTime());
            submission.setMemoryUsed(
                    judgeResponse.getMemory() != null
                            ? judgeResponse.getMemory().longValue()
                            : null
            );

            Integer statusId = judgeResponse.getStatus().getId();

            if (statusId != 3) {
                submission.setSubmissionStatus(
                        judgeResponse.getStatus().getDescription()
                );
                allPassed = false;
                break;
            }

            boolean passed = compareOutput(
                    judgeResponse.getStdout(),
                    testCase.getSampleOutput()
            );

            if (!passed) {
                submission.setSubmissionStatus("Wrong Answer");
                allPassed = false;
                break;
            }
        }

        if (allPassed) {
            submission.setSubmissionStatus("Accepted");
        }

        savedSubmission = srepo.save(submission);

        return convertToDTO(savedSubmission);
    }
    @Override
    public SubmissionResponseDTO getSubmission(Long submissionId) {

        Submissions submission = srepo.findById(submissionId).orElse(null);

        if (submission == null) {
            return null;
        }
        

        return convertToDTO(submission);
    }

    @Override
    public List<SubmissionResponseDTO> getAllSubmissions() {

        return srepo.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
 
    private SubmissionResponseDTO convertToDTO(Submissions submission) {

        SubmissionResponseDTO dto = new SubmissionResponseDTO();

        dto.setSubmissionId(submission.getSubmissionId());
        dto.setUserId(submission.getUserId());

        if (submission.getProblem() != null) {
            dto.setProbId(submission.getProblem().getProbId());
            dto.setProbTitle(submission.getProblem().getProbTitle());
        }

        dto.setSourceCode(submission.getSourceCode());
        dto.setLanguage(submission.getLanguage());
        dto.setSubmissionStatus(submission.getSubmissionStatus());
        dto.setExecutionTime(submission.getExecutionTime());
        dto.setMemoryUsed(submission.getMemoryUsed());
        dto.setSubmittedAt(submission.getSubmittedAt());

        return dto;
    }
    
        @Override
    public void deleteSubmission(Long submissionId) {

        if (!srepo.existsById(submissionId)) {
            throw new RuntimeException("Submission not found");
        }

        srepo.deleteById(submissionId);
    }
    //language 
    private Integer getLanguageId(String language) {

        if (language.equalsIgnoreCase("JAVA")) {
            return 91;
        }
        else if (language.equalsIgnoreCase("PYTHON")) {
            return 71;
        }
        else if (language.equalsIgnoreCase("CPP")) {
            return 54;
        }

        throw new RuntimeException("Unsupported programming language");
    }
    private boolean compareOutput(String actualOutput, String expectedOutput) {

        if (actualOutput == null || expectedOutput == null) {
            return false;
        }

        return actualOutput.trim().equals(expectedOutput.trim());
    }
}