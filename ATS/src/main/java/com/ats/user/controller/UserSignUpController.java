package com.ats.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ats.constants.ATSConstants;
import com.ats.user.model.UserModel;
import com.ats.user.service.UserServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * 
 * @author pavan
 *
 *
 */

@Controller
@Api
public class UserSignUpController {
	

	/**
	 * injecting the UserServiceImpl class object.
	 */
	
	@Autowired
	private UserServiceImpl service;

	
	@ApiOperation("this method is used to display user sign up form")	
	/**
	 * 
	 * @param model
	 * @return view this will display the userSignUp page
	 */
	@GetMapping("/signup")
	public String signUp(Model model) {

		UserModel userModel = new UserModel();
		model.addAttribute("userModel", userModel);

		return ATSConstants.USER_SIGN_UP;

	}
	
	/**
	 * 
	 * @param userModel this is used to capture the data from userSignUp view page
	 * @param model
	 * @return this is returns message whether registration is success or fail to userSignUp view page
	 * @throws Exception
	 */

	@PostMapping("/register")
	public String register(@ModelAttribute("userModel") UserModel userModel, Model model) throws Exception {

		boolean saveDetails = service.saveDetails(userModel);
		if (saveDetails) {			
			model.addAttribute("msg",ATSConstants.REG_SUCCESS);
			return ATSConstants.USER_SIGN_UP;
		}
		model.addAttribute("msg",ATSConstants.REG_FAIL);
		return ATSConstants.USER_SIGN_UP;

	}


	/*
	 * @InitBinder public void initBinder(WebDataBinder binder) { SimpleDateFormat
	 * dateFormat = new SimpleDateFormat("dd-mm-yyyy");
	 * binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,
	 * true)); }
	 */
	
	
}
