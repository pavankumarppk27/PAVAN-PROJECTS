package com.ats.batches.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.batches.entity.TagTxTriggersEntity;

@Repository
public interface TagTxTriggerRepository  extends JpaRepository<TagTxTriggersEntity, Long>{
	
	
	@Query("from TagTxTriggersEntity where TX_STATUS=:status and TX_FAILURE_RSN=:reason and CREATE_DT=:date and REMINDER_MSG_SW=:remainderSw")
	public List<TagTxTriggersEntity> findByAllPendingTrgs(String status,String reason,java.sql.Date date,String remainderSw);
	
}