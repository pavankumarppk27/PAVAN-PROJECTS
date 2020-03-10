package com.rto.restcontroller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rto.bindings.VehicleSummary;
import com.rto.exception.VehicleRegistrationNumbeException;
import com.rto.service.VehicleRegisterDetailsService;
import com.rto.service.VehicleSummaryServiceImpl;

@RestController
public class VehicleDetailsRestController {

	@Autowired
	private VehicleSummaryServiceImpl vehicleSummary;
	
	@Autowired
	VehicleRegisterDetailsService vehicleRegisterDetailsService;
	


	@GetMapping(value = "/getVehicleDetails" ,produces = {"application/xml","application/json"})
	public VehicleSummary getVehicleDetailsByRegisterId(@PathParam("regNum")String regNum) {

		VehicleSummary vehicleDetailsByRegId=null;
		if(vehicleRegisterDetailsService.isExistsRegNum(regNum)){
		  
			vehicleDetailsByRegId=vehicleSummary.getVehicleDetailsByRegId(regNum);
		}else {
			
			throw new VehicleRegistrationNumbeException();
		}
		return vehicleDetailsByRegId;
		//return "vehicleDetailsByRegId";

	}

}
