package com.spacecoder.coding.service;

import java.util.List;


import com.spacecoder.coding.dto.SubmissionRequestDTO;

import com.spacecoder.coding.dto.SubmissionResponseDTO;
import com.spacecoder.coding.entity.Submissions;

public interface SubmissionService {
 
	
	  public SubmissionResponseDTO saveSubmission(SubmissionRequestDTO dto);

	  public  SubmissionResponseDTO getSubmission(Long submissionId);

	   public List<SubmissionResponseDTO> getAllSubmissions();
	   public void deleteSubmission(Long submissionId);
}
