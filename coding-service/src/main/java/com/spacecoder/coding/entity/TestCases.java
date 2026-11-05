
package com.spacecoder.coding.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;

import lombok.Data;

@Entity
@Data
@Table(name = "test_cases")
public class TestCases {

    @Id
    private Long testCaseId;

    @ManyToOne
    @JoinColumn(name = "prob_id")
    private Problems problem;

    @Column(columnDefinition = "TEXT")
    private String sampleInput;

    @Column(columnDefinition = "TEXT")
    private String sampleOutput;

    private Boolean isHidden;
}