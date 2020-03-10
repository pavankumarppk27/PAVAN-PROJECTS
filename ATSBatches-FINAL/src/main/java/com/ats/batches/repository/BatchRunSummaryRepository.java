package com.ats.batches.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.batches.entity.BatchRunSummaryEntity;

@Repository
public interface BatchRunSummaryRepository  extends JpaRepository<BatchRunSummaryEntity, Long>{ 
}
	


