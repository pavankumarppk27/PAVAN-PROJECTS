package com.ats.batches.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.batch.constants.BatchesConstants;
import com.ats.batches.entity.BatchRunDtlsEntity;
import com.ats.batches.entity.UserMasterEntity;
import com.ats.batches.repository.BatchRunDtlsRepository;
import com.ats.batches.repository.TagTxTriggerRepository;
import com.ats.batches.util.EmailFileReader;
import com.ats.batches.util.EmailService;

@Service
public class LowBalanceRemainderHelperImpl implements LowBalanceRemainderHelper {

	@Autowired
	private EmailService emailService;

	@Autowired
	private TagTxTriggerRepository tagTxTrRepo;

	@Autowired
	private BatchRunDtlsRepository batchRunDtlsRepo;

	@Override
	public void sendMessage(Long phoneNo) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean sendMail(UserMasterEntity userEntiy) {

		try {

			String readMailBody = EmailFileReader.readMailBody(userEntiy);
			emailService.sendEmail(readMailBody);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public void updateTrgsOfCompleted(Long txId) {
		// TODO logic to update batch run details

		tagTxTrRepo.updateTrgOfCompleted("C", txId);

	}

	@Override
	public void updateBatchRunDtls(Long runId) {
		// TODO Auto-generated method stub

		Optional<BatchRunDtlsEntity> entity = batchRunDtlsRepo.findById(runId);
		if (entity.isPresent()) {

			BatchRunDtlsEntity batchRunDtlsEntity = entity.get();
			batchRunDtlsEntity.setRunStatus(BatchesConstants.ENDED);
			batchRunDtlsEntity.setUpdatedBy(BatchesConstants.BATCH_NAME);

			batchRunDtlsRepo.save(batchRunDtlsEntity);

		}

	}

}
