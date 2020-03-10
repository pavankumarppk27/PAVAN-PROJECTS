package com.ats.batches.service;

import com.ats.batches.entity.UserMasterEntity;

public interface LowBalanceRemainderHelper {
	
	
	public void sendMessage(Long phoneN);
	
	
	public boolean sendMail(UserMasterEntity userEntiy) throws Exception;
	
	public void updateTrgsOfCompleted(Long txId);
	
	public void updateBatchRunDtls(Long runId);
	

}
