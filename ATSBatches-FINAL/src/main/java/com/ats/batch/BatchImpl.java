package com.ats.batch;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ats.batch.constants.BatchesConstants;
import com.ats.batches.entity.BatchRunDtlsEntity;
import com.ats.batches.entity.BatchRunSummaryEntity;
import com.ats.batches.entity.TagTxTriggersEntity;
import com.ats.batches.entity.UserMasterEntity;
import com.ats.batches.repository.BatchRunDtlsRepository;
import com.ats.batches.repository.BatchRunSummaryRepository;
import com.ats.batches.repository.TagMasterRepository;
import com.ats.batches.repository.TagTxTriggerRepository;
import com.ats.batches.repository.UserMasterRepository;
import com.ats.batches.service.LowBalanceRemainderHelper;

@Controller
public class BatchImpl implements Batch {

	public static Integer SUCCESS_COUNT=0;
	public static Integer FAILED_COUNT=0;
	public static Integer TOTAL_COUNT=0;

	@Autowired
	private BatchRunDtlsRepository batchRunDtlsRepo;

	@Autowired
	private BatchRunSummaryRepository batchSummaryRepo;

	@Autowired
	private TagTxTriggerRepository tagTxTrRepo;

	@Autowired
	private TagMasterRepository tagRepo;

	@Autowired
	private UserMasterRepository userRepo;

	@Autowired
	private LowBalanceRemainderHelper helper;

	@Override
	public Long preProcess() {
		// TODO Auto-generated method stub

		BatchRunDtlsEntity entity = new BatchRunDtlsEntity();

		entity.setBatchName(BatchesConstants.BATCH_NAME);
		entity.setStartDate(new Date());
		entity.setRunStatus(BatchesConstants.STARTED);
		entity.setCreatedBy(BatchesConstants.BATCH_NAME);

		BatchRunDtlsEntity save = batchRunDtlsRepo.save(entity);

		return save.getRunId();
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub

		Date d = new Date();
		java.sql.Date date = new java.sql.Date(d.getTime());

		List<TagTxTriggersEntity> TagTxPendingTrgs = tagTxTrRepo.findAllPendingTrgs("FAILED", "LOW_BAL", "P");

		TOTAL_COUNT = TagTxPendingTrgs.size();

		/*
		 * ExecutorService executorService = Executors.newFixedThreadPool(2);
		 * CompletionService completionService = new
		 * ExecutorCompletionService(executorService);
		 * 
		 * completionService.submit(new Callable() {
		 * 
		 * public Object call() {
		 * 
		 * TagTxPendingTrgs.forEach(pendingTrgs -> {
		 * 
		 * Long trgId = pendingTrgs.getTrgId(); Long tagId = tagRepo.findByTagId(trgId);
		 * 
		 * Optional<UserMasterEntity> userEntity = userRepo.findById(tagId);
		 * 
		 * if (userEntity != null) { UserMasterEntity userMasterEntity =
		 * userEntity.get(); process(userMasterEntity); } });
		 * 
		 * return null;
		 * 
		 * }
		 * 
		 * });
		 */

		TagTxPendingTrgs.forEach(pendingTrgs -> {

			Long trgId = pendingTrgs.getTrgId();
			Long tagId = tagRepo.findByTagId(trgId);

			Optional<UserMasterEntity> userEntity = userRepo.findById(tagId);

			if (userEntity != null) {
				UserMasterEntity userMasterEntity = userEntity.get();
				process(userMasterEntity);
			}
		});

	}

	@Override
	public void process(UserMasterEntity userEntiy) {
		// TODO Auto-generated method stub
		try {
			if (helper.sendMail(userEntiy)) {
				helper.updateTrgsOfCompleted(userEntiy.getUserId());
				SUCCESS_COUNT++;
			} else {
				FAILED_COUNT++;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void postProcess() {
		// TODO Auto-generated method stub

		Long runId = preProcess();
		helper.updateBatchRunDtls(runId);

		BatchRunSummaryEntity batchSummaryEntity = new BatchRunSummaryEntity();

		batchSummaryEntity.setSummaryId(runId);
		batchSummaryEntity.setBatchName(BatchesConstants.BATCH_NAME);
		batchSummaryEntity.setCreatedBy(BatchesConstants.BATCH_NAME);
		String summaryDtls = "TOTAL:" + TOTAL_COUNT + " " + "SUCCESS_COUNT:" + SUCCESS_COUNT + " FAILED COUNT :"
				+ FAILED_COUNT;
		batchSummaryEntity.setSummaryDtls(summaryDtls);
		batchSummaryEntity.setRunStatus(BatchesConstants.ENDED);
		batchSummaryEntity.setUpdatedBy(BatchesConstants.BATCH_NAME);
		batchSummaryEntity.setEndDate(new Date());

		batchSummaryRepo.save(batchSummaryEntity);

	}
}
