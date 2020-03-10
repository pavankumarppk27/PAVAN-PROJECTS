package com.tagtransaction.service;

import com.tagtransaction.entity.TagTransactionEntity;
import com.tagtransaction.model.TagTxRequestModel;
import com.tagtransaction.model.TagTxResponseModel;
import com.tagtransaction.tag.entity.PurchaseTagEntity;
import com.tagtransaction.tag.entity.TagTxRequestEntity;

public interface TagTransactionService {
	
	public void saveTxDtls(TagTransactionEntity txEntity);
	public void saveTagDtls(PurchaseTagEntity tagEntity);
	public TagTxResponseModel validateTransactionOfVehicle(TagTxRequestModel txReqModel);
	public TagTxResponseModel validateTransaction(PurchaseTagEntity tagEntity,TagTxRequestEntity txReqEntity);
	public TagTxResponseModel checkTransactionConditions(PurchaseTagEntity tagEntity,TagTxRequestEntity txReqEntity);
	public TagTxResponseModel validateLowBal(TagTransactionEntity tagTxEntity ,TagTxRequestEntity txEntity);
	public TagTxResponseModel validateExpireDate(TagTransactionEntity tagTxEntity,TagTxRequestEntity txEntity);
	public TagTxResponseModel validateLowBalAndExpireDate(TagTransactionEntity tagTxEntity,TagTxRequestEntity txEntity);
	public TagTxResponseModel validateExpireDateAndLowBal(TagTransactionEntity tagTxEntity,TagTxRequestEntity txEntity);
    public void sendMail();

}
