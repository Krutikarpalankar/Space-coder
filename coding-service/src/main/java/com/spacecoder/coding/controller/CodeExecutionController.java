package com.spacecoder.coding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.spacecoder.coding.dto.Judge0RequestDTO;
import com.spacecoder.coding.dto.Judge0ResponseDTO;
import com.spacecoder.coding.service.CodeExecutionService;

@RestController
@RequestMapping("/api/coding/execute")
@CrossOrigin(origins = "http://localhost:5173")
public class CodeExecutionController {

    @Autowired
    CodeExecutionService codeExecutionService;

    @PostMapping("/add")
    public Judge0ResponseDTO executeCode(
            @RequestBody Judge0RequestDTO request) {

        return codeExecutionService.executeCode(request);
    }
}