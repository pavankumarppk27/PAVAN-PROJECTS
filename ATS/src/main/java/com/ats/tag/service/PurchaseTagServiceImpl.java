package com.ats.tag.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.constants.ATSConstants;
import com.ats.tag.entity.PurchaseTagEntity;
import com.ats.tag.model.PurchaseTagModel;
import com.ats.tag.repository.PurchageTagRepository;
import com.ats.user.entity.UserEntity;
import com.ats.user.repository.UserRepository;
import com.ats.util.DateUtil;
import com.ats.util.TemporaryPwdAndId;

@Service
public class PurchaseTagServiceImpl implements PurchageTagService {

	@Autowired
	private PurchageTagRepository purchageTagRepo;

	@Autowired
	private UserRepository userRepo;

	@Override
	public Long countByVehicleRegNum(String vehRegNo) {
		// TODO Auto-generated method stub

		return purchageTagRepo.countByVehicleRegNum(vehRegNo);
	}

	@Override
	public Long saveDtls(Long id, PurchaseTagModel model) {

		UserEntity userEntity = userRepo.findById(id).get();
		model.setTagExpiryDate(DateUtil.addYears(model.getTagStartDate()));
		if (model.getTagRegId() == null) {
			model.setTagRegId(TemporaryPwdAndId.generateTempTagId());
		}
		if (model.getTagSwitch() == null) {
			model.setTagSwitch(ATSConstants.TAG_VALID);
		}
		PurchaseTagEntity entity = new PurchaseTagEntity();
		BeanUtils.copyProperties(model, entity);
		entity.setUserId(userEntity);
		PurchaseTagEntity purchageTagEntity = purchageTagRepo.save(entity);

		return purchageTagEntity.getTagId();
	}

	@Override
	public PurchaseTagModel findById(Long id) {

		PurchaseTagModel model = new PurchaseTagModel();
		PurchaseTagEntity purchageTagEntity = purchageTagRepo.findById(id).get();
		BeanUtils.copyProperties(purchageTagEntity, model);

		return model;
	}

	@Override
	public PurchaseTagModel findByVehicleRegNum(String vehRegNo) {
		// TODO Auto-generated method stub
		PurchaseTagEntity purchageTagEntity = purchageTagRepo.findByVehicleRegNum(vehRegNo);
		PurchaseTagModel model = new PurchaseTagModel();
		BeanUtils.copyProperties(purchageTagEntity, model);

		return model;
	}

	@Override
	public List<PurchaseTagModel> findByUserId(Long id) {
		// TODO Auto-generated method stub

		UserEntity userEntity = userRepo.findById(id).get();
		List<PurchaseTagEntity> listPurchageTagEntity = purchageTagRepo.findByUserId(userEntity);
		List<PurchaseTagModel> listPurchageTagModel = new ArrayList<PurchaseTagModel>();

		listPurchageTagEntity.forEach(entity -> {
			PurchaseTagModel model = new PurchaseTagModel();
			BeanUtils.copyProperties(entity, model);
			model.setUserId(id);
			listPurchageTagModel.add(model);
		});

		return listPurchageTagModel;
	}

	@Override
	public Long saveRechargeDtls(Long id, PurchaseTagModel model) {

		UserEntity userEntity = userRepo.findById(id).get();
		PurchaseTagEntity entity = new PurchaseTagEntity();
		BeanUtils.copyProperties(model, entity);
		
		if(purchageTagRepo.existsByTagSwitch(ATSConstants.TAG_RENEW)) {
		PurchaseTagEntity purchaseTagEntity = purchageTagRepo.findByTagSwitch(ATSConstants.TAG_RENEW);
		if(purchaseTagEntity.getTagBal()!=null) {
			entity.setTagBal(purchaseTagEntity.getTagBal() + entity.getTagBal());
			PurchaseTagEntity tagEntity = purchageTagRepo.findByTagRegId(purchaseTagEntity.getTagRegId());
			tagEntity.setTagBal(0.0);
			tagEntity.setTagSwitch(ATSConstants.TAG_EXPIRED);
			purchageTagRepo.save(tagEntity);
		}
		}
				entity.setUserId(userEntity);
		PurchaseTagEntity purchageTagEntity = purchageTagRepo.save(entity);

		return purchageTagEntity.getTagId();
	}

	@Override
	public PurchaseTagModel findByVehicleRegNumAndTagSwitch(String vehRegNo, String tagSwitch) {
		PurchaseTagModel purchaseTagModel=new PurchaseTagModel();
		PurchaseTagEntity purchaseTagEntity=null;
		if( purchageTagRepo.existsByVehicleRegNumAndTagSwitch(vehRegNo, tagSwitch)) {
			purchaseTagEntity = purchageTagRepo.findByVehicleRegNumAndTagSwitch(vehRegNo, tagSwitch);		
			BeanUtils.copyProperties(purchaseTagEntity, purchaseTagModel);
		}
				
		return purchaseTagModel;
	}

	
	
}
