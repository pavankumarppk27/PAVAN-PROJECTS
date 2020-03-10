package com.rto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rto.model.VehicleOwnerAddressDetailsModel;
import com.rto.model.VehicleOwnerDetailsModel;
import com.rto.service.VehicleOwnerAddressDetailsService;
import com.rto.service.VehicleOwnerDetailsService;


/**
 * 
 * @author pavan
 *
 */

@Controller
public class VehicleOwnerAddressDetailsController {


	@Autowired
	private VehicleOwnerDetailsService vehicleOwnerDetailsService;

	@Autowired
	private VehicleOwnerAddressDetailsService vehicleOwnerAddressDetailsService;

	
	/**
	 * 
	 * @param model
	 * @return
	 */
	
	@GetMapping("/showOwnerAddressDetailsForm")
	public String showForm(Model model) {

		Long ownerId=(Long)model.getAttribute("ownerId");
		if(!vehicleOwnerAddressDetailsService.isExists(ownerId)) {
			
		VehicleOwnerAddressDetailsModel vehicleOwnerAddressDetailsModel = new VehicleOwnerAddressDetailsModel();		
		vehicleOwnerAddressDetailsModel.setVehicleOwnerId(ownerId);
		model.addAttribute("vehicleOwnerAddressDetailsModel", vehicleOwnerAddressDetailsModel);
		
		}else {
			VehicleOwnerAddressDetailsModel vehicleOwnerAddressDetailsModel = 	vehicleOwnerAddressDetailsService.vehicleOwnerId(ownerId);
			model.addAttribute("vehicleOwnerAddressDetailsModel", vehicleOwnerAddressDetailsModel);
		}
		
		return "vehicleowneraddressdetails";
	}

	/**
	 * 
	 * @param vehicleOwnerAddressDetailsModel
	 * @param attr
	 * @return
	 */
	
	@PostMapping("/processOwnerAddressDetailsForm")
	public String processForm(
			@ModelAttribute("vehicleOwnerAddressDetailsModel") VehicleOwnerAddressDetailsModel vehicleOwnerAddressDetailsModel,
			RedirectAttributes attr) {
		

		Long ownerId = vehicleOwnerAddressDetailsService.saveOwnerAddressDetails(vehicleOwnerAddressDetailsModel);		
		attr.addFlashAttribute("ownerId",ownerId);
		
		return "redirect:/showVehicleDetailsForm";

	} 

	/**
	 * 
	 * @param model
	 * @param ownerId
	 * @param atr
	 * @return
	 */
	@GetMapping("/editOwnerDetailsForm")
	public String handlePreviousButton(Model model,@RequestParam("ownerId") Long ownerId,RedirectAttributes atr) {

		
		VehicleOwnerDetailsModel vehicleOwnerDetailsModel = vehicleOwnerDetailsService.vehicleOwnerDetailsFindById(ownerId);
				model.addAttribute("vehicleOwnerDetailsModel",vehicleOwnerDetailsModel);
			
		return "vehicleownerdetails";
	}
	

}
