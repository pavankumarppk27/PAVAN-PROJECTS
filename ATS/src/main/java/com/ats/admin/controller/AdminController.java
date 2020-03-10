package com.ats.admin.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ats.admin.service.AdminService;
import com.ats.constants.ATSConstants;
import com.ats.user.model.UserModel;

@Controller
public class AdminController {

	@Autowired
	private AdminService service;

	@GetMapping("/admin")
	public String admin() {

		return ATSConstants.ADMIN_VIEW;
	}

	@GetMapping("/viewAgencyAccounts")
	public ModelAndView getAgencyDtls() {
		ModelAndView mav = new ModelAndView();

		List<UserModel> agencyDtls = service.getAccountsDtls(ATSConstants.AGENCY, ATSConstants.UN_LOCKED);
		mav.setViewName(ATSConstants.ADMIN_VIEW);
		mav.addObject("agencyList", agencyDtls);

		return mav;
	}

	@GetMapping("/viewUserAccounts")
	public ModelAndView getUserDtls() {
		ModelAndView mav = new ModelAndView();

		List<UserModel> userDtls = service.getAccountsDtls(ATSConstants.USER, ATSConstants.UN_LOCKED);
		mav.setViewName(ATSConstants.ADMIN_VIEW);
		mav.addObject("userList", userDtls);

		return mav;
	}

	@GetMapping("/agencyActivie")
	public ModelAndView activeAccount(@RequestParam("email") String email) {

		service.activeAccount(email);

		return getAgencyDtls();
	}

	@GetMapping("/agencyDeActivie")
	public ModelAndView deActiveAccount(@RequestParam("email") String email) {

		service.DeActiveAccount(email);

		return getAgencyDtls();
	}

	
	@GetMapping("/userActivie")
	public ModelAndView activeUserAccount(@RequestParam("email") String email) {

		service.activeAccount(email);

		return getUserDtls(); 
	}

	@GetMapping("/userDeActivie")
	public ModelAndView deActiveUserAccount(@RequestParam("email") String email) {

		service.DeActiveAccount(email);

		return getUserDtls();
	}
	
	
	@GetMapping("/editAgency")
	public String editAgency(@RequestParam("email") String email, Model model) {

		UserModel userModel = service.findByEmail(email);
		model.addAttribute(userModel);
		return ATSConstants.EDIT_AGENCY;

	}

	@PostMapping("/editAgencyDtls")
	public ModelAndView editAgencyDtls(@ModelAttribute("userModel") UserModel userModel) {

		UserModel model = service.findByEmail(userModel.getEmail());
		ModelAndView mav = new ModelAndView();
		mav.setViewName(ATSConstants.EDIT_AGENCY);
		BeanUtils.copyProperties(model, userModel, "firstName", "lastName", "email", "phoneNumber", "gender", "dob",
				"role");
		if(service.saveDtls(userModel)) {
			return mav.addObject("msg", ATSConstants.UPDATED);
		}
		mav.addObject("msg", ATSConstants.NOT_UPDATED);

		return mav;

	}

	@GetMapping("/editUser")
	public String editUser(@RequestParam("email") String email, Model model) {

		UserModel userModel = service.findByEmail(email);
		model.addAttribute(userModel);
		return ATSConstants.EDIT_USER;

	}

	@PostMapping("/editUserDtls")
	public ModelAndView editUserDtls(@ModelAttribute("userModel") UserModel userModel) {

		UserModel model = service.findByEmail(userModel.getEmail());
		ModelAndView mav = new ModelAndView();
		mav.setViewName(ATSConstants.EDIT_AGENCY);

		BeanUtils.copyProperties(model, userModel, "firstName", "lastName", "email", "phoneNumber", "gender", "dob",
				"role");
		if (service.saveDtls(userModel)) {
			mav.addObject("msg", ATSConstants.UPDATED);
			return mav;
		}
		mav.addObject("msg", ATSConstants.NOT_UPDATED);
		return mav;
	}

	@ModelAttribute("role")
	public List<String> role() {
		List<String> role = Arrays.asList("ADMIN", "AGENCY");
		return role;
	}

}
