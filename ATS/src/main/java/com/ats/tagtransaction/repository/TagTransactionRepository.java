package com.ats.tagtransaction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.tagtransaction.entity.TagTransactionEntity;

@Repository
public interface TagTransactionRepository extends JpaRepository<TagTransactionEntity, Long> {

	public List<TagTransactionEntity> findByTagRegId(String tagRegId);
	
	
	
}
