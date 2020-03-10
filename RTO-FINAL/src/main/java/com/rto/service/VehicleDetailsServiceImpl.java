package com.rto.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rto.entities.VehicleDetailsEntity;
import com.rto.entities.VehicleOwnerDetailsEntity;
import com.rto.model.VehicleDetailsModel;
import com.rto.repository.VehicleDetailsRepository;
import com.rto.repository.VehicleOwnerDetailsRepository;

@Service
public class VehicleDetailsServiceImpl implements VehicleDetailsService {

	@Autowired
	private VehicleDetailsRepository vehicleDetailsRepository;

	@Autowired
	private VehicleOwnerDetailsRepository vehicleOwnerDetailsRepository;

	@Override
	public Long saveVehicleDetails(VehicleDetailsModel vehicleDetailsModel) {
		// TODO Auto-generated method stub

		VehicleOwnerDetailsEntity vehicleOwnerDetailsEntity = vehicleOwnerDetailsRepository
				.findById(vehicleDetailsModel.getVehicleOwnerId()).get();

		VehicleDetailsEntity vehicleDetailsEntity = new VehicleDetailsEntity();
		BeanUtils.copyProperties(vehicleDetailsModel, vehicleDetailsEntity);

		vehicleDetailsEntity.setVehicleOwnerId(vehicleOwnerDetailsEntity);
		VehicleDetailsEntity save = vehicleDetailsRepository.save(vehicleDetailsEntity);

		BeanUtils.copyProperties(save, vehicleDetailsModel);

		return vehicleDetailsModel.getVehicleOwnerId();
	}

	@Override
	public VehicleDetailsModel vehicleDetailsFindById(Long id) {
		// TODO Auto-generated method stub

		VehicleDetailsEntity vehicleDetailsEntity = vehicleDetailsRepository.findById(id).get();
		VehicleDetailsModel vehicleDetailsModel = new VehicleDetailsModel();
		BeanUtils.copyProperties(vehicleDetailsEntity, vehicleDetailsModel);

		return vehicleDetailsModel;
	}

	@Override
	public boolean isPresent(Long oid) {
		// TODO Auto-generated method stub
		return vehicleDetailsRepository.existsById(oid);
	}

	@Override
	public VehicleDetailsModel vehicleOwnerId(Long oid) {
		// TODO Auto-generated method stub

		VehicleOwnerDetailsEntity vehicleOwnerDetailsEntity = vehicleOwnerDetailsRepository.findById(oid).get();
		VehicleDetailsEntity findByVehicleOwnerId = vehicleDetailsRepository
				.findByVehicleOwnerId(vehicleOwnerDetailsEntity);
		VehicleDetailsModel vehicleDetailsModel = new VehicleDetailsModel();
		BeanUtils.copyProperties(findByVehicleOwnerId, vehicleDetailsModel);
		vehicleDetailsModel.setVehicleOwnerId(oid);
		return vehicleDetailsModel;
	}

	@Override
	public boolean isExists(Long oid) {
		// TODO Auto-generated method stub
		VehicleOwnerDetailsEntity vehicleOwnerDetailsEntity = vehicleOwnerDetailsRepository.findById(oid).get();

		return vehicleDetailsRepository.existsByVehicleOwnerId(vehicleOwnerDetailsEntity);
	}

}
