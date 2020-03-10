package com.ats.tag.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.constants.ATSConstants;
import com.ats.tag.entity.PurchaseTagEntity;
import com.ats.tag.repository.PurchageTagRepository;

@Service
public class UpdateRechargeService {
	
	@Autowired
	private PurchageTagRepository tagRepo;
	
	public boolean updateRecharge(String tagRegId,Double balance) {
		
		
		PurchaseTagEntity purchaseTagEntity = tagRepo.findByTagRegId(tagRegId);
		if(purchaseTagEntity.getTagSwitch().equals(ATSConstants.TAG_VALID)) {
		purchaseTagEntity.setTagBal(purchaseTagEntity.getTagBal()+balance);
		PurchaseTagEntity tagEntity = tagRepo.save(purchaseTagEntity);
		return tagEntity.getTagId()!=null;
		}
		return false;
	}
	
	
	 public boolean existsByTagRegId(String tagRegId) {
		 
		 return tagRepo.existsByTagRegId(tagRegId);
	 }
	
	

}
