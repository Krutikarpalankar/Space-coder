package com.spacecoder.coding.dto;

import lombok.Data;

@Data
public class ProblemResponseDTO {

    private Long probId;

    private String probTitle;

    private String probDesc;

    private String probDifficulty;

    private String probConstraints;

    private String sampleInput;

    private String sampleOutput;
}