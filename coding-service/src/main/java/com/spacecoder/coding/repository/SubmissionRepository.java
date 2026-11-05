package com.spacecoder.coding.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spacecoder.coding.entity.Submissions;

public interface SubmissionRepository extends JpaRepository<Submissions,Long> {

}
