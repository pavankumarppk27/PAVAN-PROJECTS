package com.ats.batches.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ats.batches.entity.TagTxTriggersEntity;

@Repository
public interface TagTxTriggerRepository extends JpaRepository<TagTxTriggersEntity, Long> {
	/*
	 * @Query("from TagTxTriggersEntity where txStatus=:status and txFailureRsn=:failureRsn and reminderMsgSw=:sw and createDate=:date"
	 * ) public List<TagTxTriggersEntity> findAllPendingTrgs(String status, String
	 * failureRsn, String sw, java.sql.Date date);
	 */

	@Query("from TagTxTriggersEntity where txStatus=:status and txFailureRsn=:failureRsn and reminderMsgSw=:sw")
	public List<TagTxTriggersEntity> findAllPendingTrgs(String status,String failureRsn,String sw);


	@Modifying
	@Transactional
	@Query("update TagTxTriggersEntity t set t.reminderMsgSw=:rmndrMsgSw where trgId=:trgId")
	public void updateTrgOfCompleted(String rmndrMsgSw,Long trgId);


	
} 