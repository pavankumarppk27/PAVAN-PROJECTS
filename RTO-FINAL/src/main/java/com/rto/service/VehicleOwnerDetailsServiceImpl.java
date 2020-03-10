package com.rto.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rto.entities.VehicleOwnerDetailsEntity;
import com.rto.model.VehicleOwnerDetailsModel;
import com.rto.repository.VehicleOwnerDetailsRepository;

@Service
public class VehicleOwnerDetailsServiceImpl implements VehicleOwnerDetailsService {

	@Autowired
	private VehicleOwnerDetailsRepository vehicleOwnerDetailsRepository;

	@Override
	public Long saveOwnerDetails(VehicleOwnerDetailsModel vehicleOwnerDetailsModel) {
		// TODO Auto-generated method stub

		VehicleOwnerDetailsEntity vehicleOwnerDetailsEntity = new VehicleOwnerDetailsEntity();
		BeanUtils.copyProperties(vehicleOwnerDetailsModel, vehicleOwnerDetailsEntity);

		 VehicleOwnerDetailsEntity save = vehicleOwnerDetailsRepository.save(vehicleOwnerDetailsEntity);
		 return save.getVehicleOwnerId();
	}

	@Override
	public VehicleOwnerDetailsModel vehicleOwnerDetailsFindById(Long id) {
		// TODO Auto-generated method stub

		VehicleOwnerDetailsEntity vehicleOwnerDetailsEntity = vehicleOwnerDetailsRepository.findById(id).get();
		VehicleOwnerDetailsModel vehicleOwnerDetailsModel = new VehicleOwnerDetailsModel();
		BeanUtils.copyProperties(vehicleOwnerDetailsEntity, vehicleOwnerDetailsModel);

		return vehicleOwnerDetailsModel;
	}

}
