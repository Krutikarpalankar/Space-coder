package com.spacecoder.coding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spacecoder.coding.dto.SubmissionRequestDTO;
import com.spacecoder.coding.dto.SubmissionResponseDTO;
import com.spacecoder.coding.service.SubmissionService;

@RestController
@RequestMapping("/api/coding/submissions")
@CrossOrigin(origins = "http://localhost:5173")
public class SubmissionController {

    @Autowired
    SubmissionService sservice;

    @PostMapping("/add")
    public SubmissionResponseDTO saveSubmission(
            @RequestBody SubmissionRequestDTO dto) {

        return sservice.saveSubmission(dto);
    }

    @GetMapping
    public List<SubmissionResponseDTO> getAllSubmissions() {

        return sservice.getAllSubmissions();
    }

    @GetMapping("/{id}")
    public SubmissionResponseDTO getSubmissionById(
            @PathVariable Long id) {

        return sservice.getSubmission(id);
    }

    @DeleteMapping("/{id}")
    public String deleteSubmission(@PathVariable Long id) {
        sservice.deleteSubmission(id);
        return "Submission deleted successfully";
    }
}
