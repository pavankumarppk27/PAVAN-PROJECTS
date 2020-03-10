package com.ats.tag.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ats.exception.VehicleRegistrationNumbeException;
import com.ats.rto.bindings.VehicleSummary;

@Service
public class SearchVehRegNoClientService {

	@Autowired
	private RestTemplate restTemplate;

	public VehicleSummary searchVehRegNo(String vehRegNo) {
		// TODO Auto-generated method stub

		String rtoUrl = "http://localhost:8877/getVehicleDetails?regNum=" + vehRegNo;

//	VehicleSummary forObject = restTemplate.getForObject(rtoUrl, VehicleSummary.class);
		// System.out.println(forObject.getVehicleOwnerAddressDetailsModel().getVehicleOwnerId());
		ResponseEntity<VehicleSummary> responseEntity = null;
		try {

			responseEntity = restTemplate.exchange(rtoUrl, HttpMethod.GET, null, VehicleSummary.class, vehRegNo);
			int statusCode = responseEntity.getStatusCode().value();

			if (statusCode == 200) {

				return responseEntity.getBody();
			}
		} catch (Exception e) {

			throw new VehicleRegistrationNumbeException();
		}
		/*
		 * int statusCode = responseEntity.getStatusCode().value();
		 * 
		 * if(statusCode==400) {
		 * 
		 * return null; }else { return responseEntity.getBody();
		 *
		 */
		return responseEntity.getBody();

	}

}
