package com.spacecoder.coding.entity;

import java.time.LocalDateTime;

import org.springframework.beans.factory.parsing.Problem;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;
import lombok.Data;

@Entity
@Data
@Table(name = "submissions")
public class Submissions{

    @Id
    private Long submissionId;

    private Long userId;
   
    @ManyToOne
    @JoinColumn(name = "prob_id")
    private Problems problem;

    @Column(columnDefinition = "TEXT")
    private String sourceCode;

    private String language;

    private String submissionStatus;

    private Double executionTime;

    private Long memoryUsed;

    private LocalDateTime submittedAt;

    @PrePersist
    public void onSubmit() {
        submittedAt = LocalDateTime.now();
    }
}