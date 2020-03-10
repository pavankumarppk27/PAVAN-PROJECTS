package com.tagtransaction.tag.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tagtransaction.tag.entity.PurchaseTagEntity;

@Repository
public interface PurchageTagRepository extends JpaRepository<PurchaseTagEntity,Long> {

public PurchaseTagEntity findByTagRegId(String tagRegId);
	  
	
}
