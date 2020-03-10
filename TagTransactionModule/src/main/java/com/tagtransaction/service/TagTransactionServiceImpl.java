package com.tagtransaction.service;

import java.util.Date;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tagtransaction.constants.TagTxConstants;
import com.tagtransaction.entity.TagTransactionEntity;
import com.tagtransaction.model.TagTxRequestModel;
import com.tagtransaction.model.TagTxResponseModel;
import com.tagtransaction.repository.TagTransactionRepository;
import com.tagtransaction.tag.entity.PurchaseTagEntity;
import com.tagtransaction.tag.entity.TagTxRequestEntity;
import com.tagtransaction.tag.entity.UserEntity;
import com.tagtransaction.tag.repository.PurchageTagRepository;
import com.tagtransaction.tag.repository.UserRepository;
import com.tagtransaction.util.EmailFileReader;
import com.tagtransaction.util.EmailService;

@Service
public class TagTransactionServiceImpl implements TagTransactionService {

	@Autowired
	private TagTransactionRepository repo;

	@Autowired
	private PurchageTagRepository purchageTagRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private EmailService emailService;

	TagTxResponseModel txRespModel = null;
	TagTransactionEntity tagTxEntity = null;
	PurchaseTagEntity tagEntity=null;
	TagTxRequestEntity txReqEntity=null;
	UserEntity userEntity =null;

	@Override
	public void saveTxDtls(TagTransactionEntity txEntity) {
			
		repo.save(txEntity);
	}
	@Override
	public void saveTagDtls(PurchaseTagEntity tagEntity) {
		
		purchageTagRepo.save(tagEntity);
	}


	@Override
	public TagTxResponseModel validateTransactionOfVehicle(TagTxRequestModel txReqModel) {
		// TODO Auto-generated method stub

		txReqEntity = new TagTxRequestEntity();
		BeanUtils.copyProperties(txReqModel, txReqEntity);
		String tagRegId = txReqModel.getTagRegId();
		tagEntity = purchageTagRepo.findByTagRegId(tagRegId);
		userEntity = userRepo.findById(this.tagEntity.getUserId()).get();
		
		TagTxResponseModel txResponseModel = validateTransaction(tagEntity, txReqEntity);
		
		//sending mail
		sendMail();
		//saving Transactional Details
		saveTxDtls(tagTxEntity);
		//saving Tag Details
		saveTagDtls(tagEntity);
		
		return txResponseModel;
	}

	
	@Override
	public TagTxResponseModel validateTransaction(PurchaseTagEntity tagEntity, TagTxRequestEntity txReqEntity) {

		txRespModel = new TagTxResponseModel();
		txRespModel.setTagRegId(txReqEntity.getTagRegId());
		txRespModel.setVehRegNo(txReqEntity.getVehRegNum());

		tagTxEntity = new TagTransactionEntity();
		tagTxEntity.setTagRegId(txReqEntity.getTagRegId());
		tagTxEntity.setTollPlazaId(txReqEntity.getTollPlazaId());
		tagTxEntity.setVehicleRegNo(txReqEntity.getVehRegNum());
		tagTxEntity.setTollPlazaAmount(txReqEntity.getTollAmt());

		return checkTransactionConditions(tagEntity, txReqEntity);
	}
	
	
	@Override
	public TagTxResponseModel checkTransactionConditions(PurchaseTagEntity tagEntity, TagTxRequestEntity txReqEntity) {
		
		if ((new Date().compareTo(tagEntity.getTagExpiryDate()) <= -1)&& (tagEntity.getTagBal() >= txReqEntity.getTollAmt())) {		
		
			return validateExpireDateAndLowBal(tagTxEntity, txReqEntity);
		} else if ((new Date().compareTo(tagEntity.getTagExpiryDate()) != -1) && (tagEntity.getTagBal() < txReqEntity.getTollAmt())) {						
		    
			return validateLowBalAndExpireDate(tagTxEntity, txReqEntity);
		} else if ((new Date().compareTo(tagEntity.getTagExpiryDate()) <= -1) && (tagEntity.getTagBal() < txReqEntity.getTollAmt())) {
									
			return validateLowBal(tagTxEntity, txReqEntity);
		} else if ((new Date().compareTo(tagEntity.getTagExpiryDate()) != -1) && (tagEntity.getTagBal() >= txReqEntity.getTollAmt())) {
			
	        return validateExpireDate(tagTxEntity, txReqEntity);
		}
		return txRespModel;
	}
	
	
	@Override
	public TagTxResponseModel validateExpireDateAndLowBal(TagTransactionEntity tagTxEntity,
			TagTxRequestEntity txEntity) {
		// TODO Auto-generated method stub

		tagTxEntity.setTransactionStatus(TagTxConstants.TAG_TX_SUCCESS);
		txRespModel.setTxStatus(TagTxConstants.TAG_TX_SUCCESS);
		this.tagEntity.setTagBal(tagEntity.getTagBal() - txReqEntity.getTollAmt());

		return txRespModel;
	}

	@Override
	public TagTxResponseModel validateLowBalAndExpireDate(TagTransactionEntity tagTxEntity,
			TagTxRequestEntity txEntity) {

		tagTxEntity.setTransactionStatus(TagTxConstants.TAG_TX_FAIL);
		tagTxEntity.setTransactionFailureReason(TagTxConstants.TAG_EXP_LOW_BAL);

		txRespModel.setTxStatus(TagTxConstants.TAG_TX_FAIL);
		txRespModel.setFailureReason(TagTxConstants.TAG_EXP_LOW_BAL);
		
		this.tagEntity.setTagSwitch(TagTxConstants.TAG_RENEW);
		this.tagEntity.setTagBal(tagEntity.getTagBal()-txReqEntity.getTollAmt());
		
		return txRespModel;
	}
	
	@Override
	public TagTxResponseModel validateLowBal(TagTransactionEntity tagTxEntity, TagTxRequestEntity txEntity) {
		// TODO Auto-generated method stub

		tagTxEntity.setTransactionStatus(TagTxConstants.TAG_TX_FAIL);
		tagTxEntity.setTransactionFailureReason(TagTxConstants.TAG_LOW_BAL);

		txRespModel.setTxStatus(TagTxConstants.TAG_TX_FAIL);
		txRespModel.setFailureReason(TagTxConstants.TAG_LOW_BAL);
		
		this.tagEntity.setTagBal(tagEntity.getTagBal()-txReqEntity.getTollAmt());
			
		return txRespModel;
	}

	@Override
	public TagTxResponseModel validateExpireDate(TagTransactionEntity tagTxEntity, TagTxRequestEntity txEntity) {

		tagTxEntity.setTransactionStatus(TagTxConstants.TAG_TX_FAIL);
		tagTxEntity.setTransactionFailureReason(TagTxConstants.TAG_EXPIRED);

		txRespModel.setTxStatus(TagTxConstants.TAG_TX_FAIL);
		txRespModel.setFailureReason(TagTxConstants.TAG_EXPIRED);
		
		this.tagEntity.setTagSwitch(TagTxConstants.TAG_RENEW);
		this.tagEntity.setTagBal(tagEntity.getTagBal()-txReqEntity.getTollAmt());
			
		return txRespModel;
	}
	
	
	@Override
	public void sendMail() {
			
        try {
			String mailBody = EmailFileReader.readMailBody(userEntity, tagEntity,txReqEntity);
			emailService.sendEmail(mailBody);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
