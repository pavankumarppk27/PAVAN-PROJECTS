package com.rto.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rto.model.VehicleDetailsModel;
import com.rto.model.VehicleRegisterDetailsModel;
import com.rto.service.VehicleDetailsService;
import com.rto.service.VehicleRegisterDetailsService;

/**
 * 
 * @author pavan
 *
 */

@Controller
public class VehicleRegisterDetailsController {

	@Autowired
	private VehicleDetailsService vehicleDetailsService;

	@Autowired
	private VehicleRegisterDetailsService vehicleRegisterDetailsService;

	/**
	 * 
	 * @param model
	 * @return
	 */

	@GetMapping("/showVehicleRegisterDetailsForm")
	public String index(Model model) {

		Long ownerId = (Long) model.getAttribute("ownerId");

		if (!vehicleRegisterDetailsService.isExists(ownerId)) {
			VehicleRegisterDetailsModel vehicleRegisterDetailsModel = new VehicleRegisterDetailsModel();
			vehicleRegisterDetailsModel.setVehicleOwnerId(ownerId);
			model.addAttribute(vehicleRegisterDetailsModel);
		} else {

			VehicleRegisterDetailsModel vehicleRegisterDetailsModel = vehicleRegisterDetailsService
					.vehicleOwnerId(ownerId);
			model.addAttribute(vehicleRegisterDetailsModel);

		}

		return "vehicleregisterdetails";
	}

	/**
	 * 
	 * @param vehicleRegisterDetailsModel
	 * @param attr
	 * @return
	 */
	@PostMapping("/processVehicleRegisterDetailsForm")
	public String handleNextButton(
			@ModelAttribute("vehicleRegisterDetailsModel") VehicleRegisterDetailsModel vehicleRegisterDetailsModel,
			RedirectAttributes attr) {

		Long ownerId = vehicleRegisterDetailsService.saveRegisterDetails(vehicleRegisterDetailsModel);
		attr.addFlashAttribute("ownerId", ownerId);

		return "redirect:/showPreviewLogInForm";
	}

	/**
	 * 
	 * @param model
	 * @param ownerId
	 * @return
	 */
	@GetMapping("/editVehicleDetailsForm")
	public String handlePreviousButton(Model model, @RequestParam("ownerId") Long ownerId) {

		VehicleDetailsModel vehicleDetailsModel = vehicleDetailsService.vehicleOwnerId(ownerId);
		model.addAttribute(vehicleDetailsModel);

		return "vehicledetails";
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
