package com.spacecoder.coding.dto;

import lombok.Data;

@Data
public class TestCaseResponseDTO {

	  private Long testCaseId;

	    private Long probId;

	    private String sampleInput;

	    private String sampleOutput;

	    private Boolean hidden;
}
