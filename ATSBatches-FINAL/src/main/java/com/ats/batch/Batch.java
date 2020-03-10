package com.ats.batch;

import com.ats.batches.entity.UserMasterEntity;

public interface Batch {
	
	
	public Long preProcess();
	
	public void start();
	
	public void process(UserMasterEntity entiy) ;
	
	public void postProcess();
	

}
