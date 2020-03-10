package com.ats.tag.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ats.constants.ATSConstants;
import com.ats.exception.VehicleRegistrationNumbeException;
import com.ats.rto.bindings.VehicleSummary;
import com.ats.tag.service.SearchVehRegNoClientService;

@Controller
public class SearchVehRegNoController {

	@Autowired
	private SearchVehRegNoClientService service;

	@GetMapping("/searchVegRegNo")
	public String searchVehRegNo() {

		return ATSConstants.SEARCH_VEH_REGNO_VIEW;
	}

	@GetMapping("/search")
	public ModelAndView search( HttpSession session,@RequestParam("vehRegNo") String vehRegNo, Model model) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName( ATSConstants.SEARCH_VEH_REGNO_VIEW);
		VehicleSummary vehicleSummary = service.searchVehRegNo(vehRegNo);
		if (vehicleSummary != null) {
		mav.addObject("vehicleSummary", vehicleSummary);
		session.setAttribute("vehlSummary", vehicleSummary);
		}else {
			throw new VehicleRegistrationNumbeException();
		}

		return mav;
	}

}
