package com.spacecoder.coding.service;

import com.spacecoder.coding.dto.Judge0RequestDTO;
import com.spacecoder.coding.dto.Judge0ResponseDTO;

public interface CodeExecutionService {

    Judge0ResponseDTO executeCode(Judge0RequestDTO request);

}