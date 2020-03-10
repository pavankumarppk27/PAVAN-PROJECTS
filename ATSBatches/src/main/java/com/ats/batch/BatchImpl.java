package com.ats.batch;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ats.batches.entity.BatchRunDtlsEntity;
import com.ats.batches.entity.BatchRunSummaryEntity;
import com.ats.batches.entity.TagTxTriggersEntity;
import com.ats.batches.entity.UserMasterEntity;
import com.ats.batches.repository.BatchRunDtlsRepository;
import com.ats.batches.repository.BatchRunSummaryRepository;
import com.ats.batches.repository.TagMasterRepository;
import com.ats.batches.repository.TagTxTriggerRepository;
import com.ats.batches.repository.UserMasterRepository;
import com.ats.batches.service.LowBalanceRemainderHelperImpl;

public class BatchImpl implements Batch {

	private static final String BATCH_NAME = "LWBL_RMNDR_DTLS";
	
	private static Integer SUCCESS_COUNT=0;
	private static Integer FAILED_COUNT=0;
	private static Integer TOTAL_COUNT=0;

	@Autowired
	private BatchRunDtlsRepository batchRunDtlsRepo;

	@Autowired
	private TagTxTriggerRepository tagTxTrgRepo;

	@Autowired
	private TagMasterRepository tagMasterRepo;

	@Autowired
	private UserMasterRepository userMasterRepo;
	
	@Autowired
	private LowBalanceRemainderHelperImpl lowBalHelper;
	
	@Autowired
	private BatchRunSummaryRepository batchSummaryRepo;

	@Override
	public void preProcess() {
		// TODO Auto-generated method stub

		BatchRunDtlsEntity entity = new BatchRunDtlsEntity();

		entity.setBATCH_NAME(BATCH_NAME);
		entity.setRUN_STATUS("ST");
		entity.setSTART_DT(new Date());
		entity.setCREATE_BY(BATCH_NAME);

		BatchRunDtlsEntity batchRunDtlsEntity = batchRunDtlsRepo.save(entity);

		Long run_ID = batchRunDtlsEntity.getRUN_ID();

	}

	@Override
	public void start() {
		// TODO Auto-generated method stub

		Date d = new Date();
		java.sql.Date date = new java.sql.Date(d.getTime());
		List<TagTxTriggersEntity> pendingTrgs = tagTxTrgRepo.findByAllPendingTrgs("FAILED", "LOW_BAL", date, "P");

		TOTAL_COUNT=pendingTrgs.size();
		
		for (TagTxTriggersEntity entity : pendingTrgs) {

			Long trgId = entity.getTrgId();
			Long tagId = entity.getTagId();
			
			Long userId = tagMasterRepo.findByTagId(tagId);
			Optional<UserMasterEntity> optional = userMasterRepo.findById(userId);

			if (optional.isPresent()) {

				UserMasterEntity userMasterEntity = optional.get();
				process(trgId,userMasterEntity.getMOBILE_NUM(),userMasterEntity.getEmail_ID());
				
			}
		}
	}

	@Override
	public void process(Long txId,Long phoneNo,String email) {
		// TODO Auto-generated method stub
		
		try {
			
			//logic to mobile			
			lowBalHelper.sendMessage(phoneNo);
			//logic to email
			lowBalHelper.sendMail(email);
			
			lowBalHelper.updateTrgsOfCompleted(txId);
			SUCCESS_COUNT++;
			
		}catch(Exception e) {
			
			FAILED_COUNT++;		
		}
	}

	@Override
	public void postProcess(Long runSeqId) {
		// TODO Auto-generated method stub
		
		BatchRunSummaryEntity batchSummaryEntity=new BatchRunSummaryEntity();
		
		batchSummaryEntity.setCREATE_BY(BATCH_NAME);
		String summaryDtls="TOTAL:"+TOTAL_COUNT+" "+"FAILED :"+FAILED_COUNT;
		batchSummaryEntity.setSUMMARY_DTLS(summaryDtls);
		
		batchSummaryRepo.save(batchSummaryEntity);
		
		lowBalHelper.updateBatchRunDtls(runSeqId);
		
	}

}
