package com.ats.batches.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.batches.entity.BatchRunDtlsEntity;

@Repository
public interface BatchRunDtlsRepository  extends JpaRepository<BatchRunDtlsEntity,Long>{ 
	

}
