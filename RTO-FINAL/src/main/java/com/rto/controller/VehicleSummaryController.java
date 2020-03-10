package com.rto.controller;

import java.util.Arrays;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rto.model.VehicleDetailsModel;
import com.rto.model.VehicleOwnerAddressDetailsModel;
import com.rto.model.VehicleOwnerDetailsModel;
import com.rto.model.VehicleRegisterDetailsModel;
import com.rto.service.VehicleDetailsService;
import com.rto.service.VehicleOwnerAddressDetailsService;
import com.rto.service.VehicleOwnerDetailsService;
import com.rto.service.VehicleRegisterDetailsService;


/**
 * 
 * @author pavan
 *
 */
@Controller
public class VehicleSummaryController {

	@Autowired
	VehicleOwnerDetailsService vehicleOwnerDetailsService;

	@Autowired
	VehicleOwnerAddressDetailsService vehicleOwnerAddressDetailsService;

	@Autowired
	VehicleDetailsService vehicleDetailService;

	@Autowired
	VehicleRegisterDetailsService vehicleRegisterDetailsService;

	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/showPreviewLogInForm")
	public ModelAndView showPreviewLogInForm(Model model) {

		Long ownerId = (Long) model.getAttribute("ownerId");

		model.addAttribute("ownerId", ownerId);

		VehicleOwnerDetailsModel vehicleOwnerDetailsFindById = vehicleOwnerDetailsService
				.vehicleOwnerDetailsFindById(ownerId);

		VehicleOwnerAddressDetailsModel vehicleOwnerAddressDetailsFindById = vehicleOwnerAddressDetailsService
				.vehicleOwnerId(ownerId);

		VehicleDetailsModel vehicleDetailsFindById = vehicleDetailService.vehicleOwnerId(ownerId);

		VehicleRegisterDetailsModel vehicleRegisterDetailsFindById = vehicleRegisterDetailsService
				.vehicleOwnerId(ownerId);

		ModelAndView mav = new ModelAndView();

		mav.setViewName("vehiclepreview");

		mav.addObject("vod", vehicleOwnerDetailsFindById);
		mav.addObject("voad", vehicleOwnerAddressDetailsFindById);
		mav.addObject("vd", vehicleDetailsFindById);
		mav.addObject("ownerId", ownerId);

		mav.addObject("vrd", vehicleRegisterDetailsFindById);

		return mav;
	}
	
	/**
	 * 
	 * @param ownerId
	 * @return
	 */

	@PostMapping("/userInfo")
	public ModelAndView userInfo(@PathParam("ownerId") Long ownerId) {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("vehicleuserinfo");

		VehicleOwnerDetailsModel vehicleOwnerDetailsFindById = vehicleOwnerDetailsService
				.vehicleOwnerDetailsFindById(ownerId);
		mav.addObject("vod", vehicleOwnerDetailsFindById);
		VehicleDetailsModel vehicleDetailsFindById = vehicleDetailService.vehicleOwnerId(ownerId);
		mav.addObject("vd", vehicleDetailsFindById);
		VehicleRegisterDetailsModel vehicleRegisterDetailsFindById = vehicleRegisterDetailsService
				.vehicleOwnerId(ownerId);
		mav.addObject("vrd", vehicleRegisterDetailsFindById);

		
		
		return mav;

	}
	
	/**
	 * 
	 * @param model
	 * @param ownerId
	 * @return
	 */

	@GetMapping("/editVehicleRegisterDetailsForm")
	public String handlePreviousButton(Model model, @RequestParam("ownerId") Long ownerId) {

		VehicleRegisterDetailsModel vehicleRegisterDetailsModel = vehicleRegisterDetailsService.vehicleOwnerId(ownerId);
		model.addAttribute(vehicleRegisterDetailsModel);

		return "vehicleregisterdetails";
	}
	
	
	/**
	 * 
	 * @return
	 */

	@ModelAttribute("registerCenter")
	public List<String> vehicleLocation() {

		List<String> regCenterList = Arrays.asList("Hyderabad", "Guntur", "Vijayawada", "Vizag", "NarasaraoPet",
				"Amaravathi");

		return regCenterList;
	}

}
