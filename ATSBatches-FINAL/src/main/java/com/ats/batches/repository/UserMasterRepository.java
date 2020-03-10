package com.ats.batches.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.batches.entity.UserMasterEntity;

@Repository
public interface UserMasterRepository  extends JpaRepository<UserMasterEntity, Long>{
    
}
