package com.ats.batches.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.batches.entity.TagMasterEntity;

@Repository
public interface TagMasterRepository extends JpaRepository<TagMasterEntity, Long> {
	
	@Query("select tagId from TagMasterEntity where tagId=:tagId")
	public Long findByTagId(Long tagId);

}
