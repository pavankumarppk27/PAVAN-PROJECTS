package com.ats.tagtransaction.service;

import java.util.List;

import com.ats.tagtransaction.model.TagTransactionModel;

public interface TagTxDetailsService {
	
	public List<TagTransactionModel> getTagTxDetails(String tagRegId);


}
