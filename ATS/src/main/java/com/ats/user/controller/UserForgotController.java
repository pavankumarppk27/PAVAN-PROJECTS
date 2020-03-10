package com.ats.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ats.constants.ATSConstants;
import com.ats.user.model.UserModel;
import com.ats.user.service.UserServiceImpl;

@Controller 
public class UserForgotController {
	
	
	
	@Autowired
	private UserServiceImpl service;

	@GetMapping("/forgot")
	public String logIn(Model model) {

		UserModel userModel = new UserModel();
		model.addAttribute("userModel", userModel);

		return ATSConstants.USER_FORGOT;

	}
	
	
	
	@PostMapping("/getForgotPwd")
	public ModelAndView getForgotPwd(@ModelAttribute("userModel") UserModel userModel) {

		ModelAndView mav=new ModelAndView();
		mav.setViewName(ATSConstants.USER_FORGOT);

		if(service.existsByEmail(userModel.getEmail())) {
			
			service.getForGetPwd(userModel.getEmail());
			mav.addObject("msg", ATSConstants.LOGIN_FORGT_PWD);
		}else {
		
		mav.addObject("msg", ATSConstants.LOGIN_WRONG_EMAIL);

		}
		return mav;

	}

}
