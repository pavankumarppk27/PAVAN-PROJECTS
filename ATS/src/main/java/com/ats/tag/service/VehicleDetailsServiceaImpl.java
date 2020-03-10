package com.ats.tag.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.rto.entity.VehicleDetailsEntity;
import com.ats.rto.entity.VehicleOwnerAddressDetailsEntity;
import com.ats.rto.entity.VehicleOwnerDetailsEntity;
import com.ats.rto.entity.VehicleRegisterDetailsEntity;
import com.ats.rto.model.VehicleDetailsModel;
import com.ats.rto.model.VehicleOwnerAddressDetailsModel;
import com.ats.rto.model.VehicleOwnerDetailsModel;
import com.ats.rto.model.VehicleRegisterDetailsModel;
import com.ats.rto.repository.VehicleDetailsRepository;
import com.ats.rto.repository.VehicleOwnerAddressDetailsRepository;
import com.ats.rto.repository.VehicleOwnerDetailsRepository;
import com.ats.rto.repository.VehicleRegisterDetailsRepository;

@Service
public class VehicleDetailsServiceaImpl implements VehicleDetailsService {
	
	@Autowired
	private VehicleOwnerDetailsRepository vehOwnrepo;
	
	@Autowired
	private VehicleOwnerAddressDetailsRepository vehOwnAddRepo;
	
	@Autowired
	private VehicleDetailsRepository vehDtlRepo;
	
	@Autowired
	private VehicleRegisterDetailsRepository vehRegDtlRepo;

	
	@Override
	public void saveVehOwnerDtls(VehicleOwnerDetailsModel model) {
		// TODO Auto-generated method stub
		VehicleOwnerDetailsEntity entity=new VehicleOwnerDetailsEntity();
		
		BeanUtils.copyProperties(model, entity);
		vehOwnrepo.save(entity);
	}

	@Override
	public void saveVehOwnerAddrDtls(VehicleOwnerAddressDetailsModel model) {
		// TODO Auto-generated method stub
		
		VehicleOwnerAddressDetailsEntity entity=new VehicleOwnerAddressDetailsEntity();
		BeanUtils.copyProperties(model, entity);
		vehOwnAddRepo.save(entity);
		
	}

	@Override
	public void saveVehDtls(VehicleDetailsModel model) {
		// TODO Auto-generated method stub
		
		VehicleDetailsEntity entity=new VehicleDetailsEntity();
		BeanUtils.copyProperties(model, entity);
		vehDtlRepo.save(entity);
		
	}

	@Override
	public void saveVehRegDtls(VehicleRegisterDetailsModel model) {
		// TODO Auto-generated method stub
		
		VehicleRegisterDetailsEntity entity=new VehicleRegisterDetailsEntity();
		BeanUtils.copyProperties(model, entity);
		vehRegDtlRepo.save(entity);

		
	}

}
