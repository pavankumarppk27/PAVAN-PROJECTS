package com.ats.admin.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ats.admin.service.AdminService;
import com.ats.constants.ATSConstants;
import com.ats.user.model.UserModel;

@Controller
public class AdminSignUpController {

	@Autowired
	private AdminService service;

	@GetMapping("/adminSignUp")
	public String logIn(Model model) {

		UserModel userModel = new UserModel();
		model.addAttribute(userModel);
		return ATSConstants.ADMIN_SIGN_UP;
	}

	@PostMapping("/adminRegister")
	public String register(@ModelAttribute("userModel") UserModel userModel, Model model) {

		if (service.saveDtls(userModel)) {
			model.addAttribute("msg", ATSConstants.REG_SUCCESS);
			return ATSConstants.ADMIN_SIGN_UP;
		}
		model.addAttribute("msg", ATSConstants.REG_FAIL);
		return ATSConstants.ADMIN_SIGN_UP;
	}

	@ModelAttribute("role")
	public List<String> role() {
		List<String> role = Arrays.asList("ADMIN", "AGENCY");
		return role;
	}

	
}
