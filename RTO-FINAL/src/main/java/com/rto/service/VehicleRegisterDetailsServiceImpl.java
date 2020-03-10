package com.rto.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rto.entities.VehicleOwnerDetailsEntity;
import com.rto.entities.VehicleRegisterDetailsEntity;
import com.rto.model.VehicleRegisterDetailsModel;
import com.rto.repository.VehicleOwnerDetailsRepository;
import com.rto.repository.VehicleRegisterDetailsRepository;
import com.rto.utility.VehicleRegistrationNumberUtility;

@Service
public class VehicleRegisterDetailsServiceImpl implements VehicleRegisterDetailsService {

	@Autowired
	private VehicleRegisterDetailsRepository vehicleRegisterDetailsRepository;

	@Autowired
	private VehicleOwnerDetailsRepository vehicleOwnerDetailsRepository;

	@Override
	public Long saveRegisterDetails(VehicleRegisterDetailsModel vehicleRegisteDetailsModel) {
		// TODO Auto-generated method stub

		VehicleOwnerDetailsEntity vehicleOwnerDetailsEntity = vehicleOwnerDetailsRepository
				.findById(vehicleRegisteDetailsModel.getVehicleOwnerId()).get();
		vehicleRegisteDetailsModel.setVehicleRegisterNumber(VehicleRegistrationNumberUtility.generateRegisterNumber());
		VehicleRegisterDetailsEntity vehicleRegisterDetailsEntity = new VehicleRegisterDetailsEntity();
		BeanUtils.copyProperties(vehicleRegisteDetailsModel, vehicleRegisterDetailsEntity);
		// setting primary key value to foreign key value
		vehicleRegisterDetailsEntity.setVehicleOwnerId(vehicleOwnerDetailsEntity);
		VehicleRegisterDetailsEntity save = vehicleRegisterDetailsRepository.save(vehicleRegisterDetailsEntity);
		
		BeanUtils.copyProperties(save, vehicleRegisteDetailsModel);

		return vehicleRegisteDetailsModel.getVehicleOwnerId();

	}

	@Override
	public VehicleRegisterDetailsModel vehicleRegisterDetailsFindById(Long id) {
		// TODO Auto-generated method stub

		VehicleRegisterDetailsEntity vehicleRegisterDetailsEntity = vehicleRegisterDetailsRepository.findById(id).get();
		VehicleRegisterDetailsModel vehicleRegisterDetailsModel = new VehicleRegisterDetailsModel();

		BeanUtils.copyProperties(vehicleRegisterDetailsEntity, vehicleRegisterDetailsModel);

		return vehicleRegisterDetailsModel;
	}


	@Override
	public VehicleRegisterDetailsModel vehicleOwnerId(Long oid) {
		// TODO Auto-generated method stub

		VehicleOwnerDetailsEntity vehicleOwnerDetailsEntity = vehicleOwnerDetailsRepository.findById(oid).get();
		VehicleRegisterDetailsEntity findByVehicleOwnerId = vehicleRegisterDetailsRepository
				.findByVehicleOwnerId(vehicleOwnerDetailsEntity);
		VehicleRegisterDetailsModel vehicleRegisterDetailsModel = new VehicleRegisterDetailsModel();
		BeanUtils.copyProperties(findByVehicleOwnerId, vehicleRegisterDetailsModel);

		vehicleRegisterDetailsModel.setVehicleOwnerId(oid);
		return vehicleRegisterDetailsModel;
	}

	@Override
	public boolean isExists(Long oid) {
		// TODO Auto-generated method stub
		VehicleOwnerDetailsEntity vehicleOwnerDetailsEntity = vehicleOwnerDetailsRepository.findById(oid).get();

		return vehicleRegisterDetailsRepository.existsByVehicleOwnerId(vehicleOwnerDetailsEntity);
	}

	@Override
	public VehicleRegisterDetailsModel findByRegNum(String regNum) {
		// TODO Auto-generated method stub
		
		VehicleRegisterDetailsEntity findByVehicleRegisterNumber = vehicleRegisterDetailsRepository.findByVehicleRegisterNumber(regNum);		
				
		VehicleOwnerDetailsEntity vehicleOwnerDetailsEntity=findByVehicleRegisterNumber.getVehicleOwnerId();
        Long ownerId=vehicleOwnerDetailsEntity.getVehicleOwnerId();
		VehicleRegisterDetailsModel vehicleRegisterDetailsModel=new VehicleRegisterDetailsModel();	
		BeanUtils.copyProperties(findByVehicleRegisterNumber, vehicleRegisterDetailsModel);
		vehicleRegisterDetailsModel.setVehicleOwnerId(ownerId);
		
		
		return vehicleRegisterDetailsModel;
	}
	
	@Override
	public boolean isExistsRegNum(String regNum) {
		// TODO Auto-generated method stub
		return vehicleRegisterDetailsRepository.existsByVehicleRegisterNumber(regNum);
	}
	

}
