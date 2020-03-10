package com.rto.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rto.model.VehicleOwnerDetailsModel;
import com.rto.service.VehicleOwnerDetailsService;

/**
 * 
 * @author pavan
 *
 */


@Controller
public class VehicleOwnerDetailsController {

	@Autowired
	private VehicleOwnerDetailsService vehicleOwnerDetailsService;
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	
	@GetMapping("/index")
	public String showForm(Model model) {

		VehicleOwnerDetailsModel vehicleOwnerDetailsModel = new VehicleOwnerDetailsModel();
		model.addAttribute("vehicleOwnerDetailsModel", vehicleOwnerDetailsModel);

		return "vehicleownerdetails";
	}

	/**
	 * 
	 * @param model
	 * @param vehicleOwnerDetailsModel
	 * @param oid
	 * @return
	 */

	@PostMapping("/processOwnerDetailsForm")
	public String handleNextButton(Model model,
			@ModelAttribute("vehicleOwnerDetailsModel") VehicleOwnerDetailsModel vehicleOwnerDetailsModel,
			RedirectAttributes attr) {
		Long ownerId = null;
		ownerId = vehicleOwnerDetailsService.saveOwnerDetails(vehicleOwnerDetailsModel);
		
			attr.addFlashAttribute("ownerId", ownerId);

		return "redirect:/showOwnerAddressDetailsForm";

	}
	
	/**
	 * 
	 * @param binder
	 */

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

}
