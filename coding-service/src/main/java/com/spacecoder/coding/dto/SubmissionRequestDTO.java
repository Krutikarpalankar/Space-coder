package com.spacecoder.coding.dto;

import lombok.Data;

@Data
public class SubmissionRequestDTO {

    private Long submissionId;
    private Long probId;
    private Long userId;
    private String sourceCode;
    private String language;
}