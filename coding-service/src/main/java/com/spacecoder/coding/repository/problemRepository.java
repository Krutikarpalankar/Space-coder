package com.spacecoder.coding.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spacecoder.coding.entity.Problems;

public interface problemRepository  extends JpaRepository<Problems,Long>{

}
