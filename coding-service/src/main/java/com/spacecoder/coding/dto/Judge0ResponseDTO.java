package com.spacecoder.coding.dto;

import lombok.Data;

@Data
public class Judge0ResponseDTO {

    private String token;
    private String stdout;
    private String stderr;
    private String compile_output;
    private String message;

    private Judge0StatusDTO status;

    private Double time;
    private Integer memory;
}
