package com.spacecoder.coding.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class SubmissionResponseDTO {

	
	  private Long submissionId;
	    private Long userId;
	    private Long probId;
	    private String language;
	    private String submissionStatus;
       private String sourceCode;
	    private Double executionTime;

	    private Long memoryUsed;

	    private LocalDateTime submittedAt;
	    private String probTitle;

		}
