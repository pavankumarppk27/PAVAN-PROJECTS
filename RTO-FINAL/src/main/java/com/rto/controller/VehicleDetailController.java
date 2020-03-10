package com.rto.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rto.model.VehicleDetailsModel;
import com.rto.model.VehicleOwnerAddressDetailsModel;
import com.rto.service.VehicleDetailsService;
import com.rto.service.VehicleOwnerAddressDetailsService;

/**
 * 
 * @author pavan
 *
 */

@Controller
public class VehicleDetailController {

	@Autowired
	private VehicleOwnerAddressDetailsService vehicleOwnerAddressDetailsService;

	@Autowired
	private VehicleDetailsService vehicleDetailsService;

	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/showVehicleDetailsForm")
	public String index(Model model) {

		Long ownerId = (Long) model.getAttribute("ownerId");

		if (!vehicleDetailsService.isExists(ownerId)) {
			VehicleDetailsModel vehicleDetailsModel = new VehicleDetailsModel();
			vehicleDetailsModel.setVehicleOwnerId(ownerId);
			model.addAttribute(vehicleDetailsModel);
		} else {
			VehicleDetailsModel vehicleDetailsModel = vehicleDetailsService.vehicleOwnerId(ownerId);
			model.addAttribute(vehicleDetailsModel);
		}
		return "vehicledetails";
	}

	/**
	 * 
	 * @param vehicleDetailsModel
	 * @param attr
	 * @return
	 */

	@PostMapping("/processVehicleDetailsForm")
	public String handleNextButton(@ModelAttribute("vehicleDetailsModel") VehicleDetailsModel vehicleDetailsModel,
			RedirectAttributes attr) {

		Long ownerId = vehicleDetailsService.saveVehicleDetails(vehicleDetailsModel);
		attr.addFlashAttribute("ownerId", ownerId);

		return "redirect:/showVehicleRegisterDetailsForm";

	}

	/**
	 * 
	 * @param model
	 * @param ownerId
	 * @return
	 */

	@GetMapping("/editOwnerAddressDetailsForm")
	public String handlePreviousButton(Model model, @RequestParam("ownerId") Long ownerId) {

		VehicleOwnerAddressDetailsModel vehicleOwnerAddressDetailsModel = vehicleOwnerAddressDetailsService
				.vehicleOwnerId(ownerId);
		model.addAttribute("vehicleOwnerAddressDetailsModel", vehicleOwnerAddressDetailsModel);

		return "vehicleowneraddressdetails";
	}

	/**
	 * 
	 * @return
	 */
	@ModelAttribute("vehicleType")
	public List<String> vehicleType() {

		List<String> vehicleTypeList = Arrays.asList("Two wheeler", "Four Wheeler", "Six Wheeler");

		return vehicleTypeList;
	}
	/**
	 * 
	 * @return
	 */

	@ModelAttribute("mfgYear")
	public List<Integer> mfgyear() {

		List<Integer> vehicleTypeList = Arrays.asList(2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010,
				2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019);

		return vehicleTypeList;
	}
	/**
	 * 
	 * @return
	 */

	@ModelAttribute("vehicleBrand")
	public List<String> vehicleBrand() {

		List<String> vehicleBrandList = Arrays.asList("Honda", "Jeep", "Ferrari", "LandRover", "BMW", "Audi", "Lexus",
				"Mini", "Hrundai", "Jaguar", "Infinity", "Tayota", "Tesla");

		return vehicleBrandList;
	}

	
}
