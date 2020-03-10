package com.rto.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rto.entities.VehicleOwnerAddressDetailsEntity;
import com.rto.entities.VehicleOwnerDetailsEntity;
import com.rto.model.VehicleOwnerAddressDetailsModel;
import com.rto.repository.VehicleOwnerAddressDetailsRepository;
import com.rto.repository.VehicleOwnerDetailsRepository;

@Service
public class VehicleOwnerAddressDetailsServiceImpl implements VehicleOwnerAddressDetailsService {

	@Autowired
	private VehicleOwnerAddressDetailsRepository vehicleOwnerAddressDetailsRepository;

	@Autowired
	private VehicleOwnerDetailsRepository vehicleOwnerDetailsRepository;

	@Override
	public Long saveOwnerAddressDetails(VehicleOwnerAddressDetailsModel vehicleOwnerAddressDetailsModel) {
		// TODO Auto-generated method stub

		VehicleOwnerAddressDetailsEntity vehicleOwnerAddressDetailsEntity = new VehicleOwnerAddressDetailsEntity();
		BeanUtils.copyProperties(vehicleOwnerAddressDetailsModel, vehicleOwnerAddressDetailsEntity);		
		VehicleOwnerDetailsEntity vehicleOwnerDetailsEntity=vehicleOwnerDetailsRepository.findById(vehicleOwnerAddressDetailsModel.getVehicleOwnerId()).get();				
		vehicleOwnerAddressDetailsEntity.setVehicleOwnerId(vehicleOwnerDetailsEntity);
		VehicleOwnerAddressDetailsEntity save = vehicleOwnerAddressDetailsRepository.save(vehicleOwnerAddressDetailsEntity);

		BeanUtils.copyProperties(save, vehicleOwnerAddressDetailsModel);

				
		return vehicleOwnerAddressDetailsModel.getVehicleOwnerId();
	}

	@Override

	public VehicleOwnerAddressDetailsModel VehicleOwnerAddressDetailsFindById(Long id) {
		// TODO Auto-generated method stub

		VehicleOwnerAddressDetailsEntity vehicleOwnerAddressDetailsEntity = vehicleOwnerAddressDetailsRepository
				.findById(id).get();
		VehicleOwnerAddressDetailsModel vehicleOwnerAddressDetailsModel = new VehicleOwnerAddressDetailsModel();
		BeanUtils.copyProperties(vehicleOwnerAddressDetailsEntity, vehicleOwnerAddressDetailsModel);

		return vehicleOwnerAddressDetailsModel;
	}

	@Override
	public boolean isPresent(Long oid) {
		// TODO Auto-generated method stub

		return vehicleOwnerAddressDetailsRepository.existsById(oid);
	}

	
	@Override
	public VehicleOwnerAddressDetailsModel vehicleOwnerId(Long oid) {
		// TODO Auto-generated method stub
		
		VehicleOwnerDetailsEntity entity=vehicleOwnerDetailsRepository.findById(oid).get();
		VehicleOwnerAddressDetailsEntity findByVehicleOwnerId = vehicleOwnerAddressDetailsRepository.findByVehicleOwnerId(entity);
		VehicleOwnerAddressDetailsModel model=new VehicleOwnerAddressDetailsModel();		
		BeanUtils.copyProperties(findByVehicleOwnerId, model);
		model.setVehicleOwnerId(oid);
		
		return model;
	}
	
	@Override
	public boolean isExists(Long oid) {
		// TODO Auto-generated method stub
		VehicleOwnerDetailsEntity entity=vehicleOwnerDetailsRepository.findById(oid).get();
		Boolean existsByVehicleOwnerId = vehicleOwnerAddressDetailsRepository.existsByVehicleOwnerId(entity);
		
		
		return existsByVehicleOwnerId;
	}

	

}
