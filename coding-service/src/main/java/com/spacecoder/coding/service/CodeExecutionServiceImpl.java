package com.spacecoder.coding.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.spacecoder.coding.dto.Judge0RequestDTO;
import com.spacecoder.coding.dto.Judge0ResponseDTO;

@Service
public class CodeExecutionServiceImpl implements CodeExecutionService {

    @Autowired
    RestClient judge0RestClient;

    @Override
    public Judge0ResponseDTO executeCode(Judge0RequestDTO request) {

        return judge0RestClient.post()
                .uri("/submissions?base64_encoded=false&wait=true")
                .header("Content-Type", "application/json")
                .body(request)
                .retrieve()
                .body(Judge0ResponseDTO.class);
    }
   
}