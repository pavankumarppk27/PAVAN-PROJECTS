package com.ats.batch;

public interface Batch {
	
	
	public void preProcess();
	
	public void start();
	
	public void process(Long txId,Long phoneNo,String email);
	
	public void postProcess(Long runSeqId);
	

}
