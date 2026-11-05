package com.spacecoder.coding.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "problems")
@Data
public class Problems {
	@Id
    private Long probId;
     private String probTitle;
     private String probDesc;
     private String probDifficulty;
     private String probConstraints;
     private String sampleInput;
     private String sampleOutput;
     @OneToMany(mappedBy = "problem")
     @JsonIgnore
     private List<Submissions> submissions;
     @OneToMany(mappedBy = "problem")
     @JsonIgnore
     private List<TestCases> testCases;
	 
}
