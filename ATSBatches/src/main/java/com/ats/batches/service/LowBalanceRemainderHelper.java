package com.ats.batches.service;

public interface LowBalanceRemainderHelper {
	
	
	public void sendMessage(Long phoneN);
	
	
	public void sendMail(String email);
	
	public void updateTrgsOfCompleted(Long txId);
	
	public void updateBatchRunDtls(Long runSeqId);
	

}
