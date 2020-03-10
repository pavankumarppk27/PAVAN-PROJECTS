package com.ats.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ats.constants.ATSConstants;
import com.ats.user.model.UserModel;
import com.ats.user.service.UserServiceImpl;
import com.ats.util.AESEncyptionAndDecryption;

@Controller
public class UserUnlockController {

	@Autowired
	private UserServiceImpl service;

	@GetMapping("/userUnLock")
	public String unLock(Model model, @RequestParam("email") String email) {

		UserModel userModel = new UserModel();
		userModel.setEmail(email);
		model.addAttribute("userModel", userModel);

		return ATSConstants.USER_UNLOCK;

	}

	@PostMapping("/unLockUserAccount")
	public ModelAndView unLockAccount(@ModelAttribute("userModel") UserModel userModel, HttpServletRequest req) {
		
		String confirmPwd = req.getParameter("pwd");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(ATSConstants.USER_UNLOCK);
		if (service.existsByEmail(userModel.getEmail())) {
			UserModel user = service.findByEmail(userModel.getEmail());
			if (userModel.getPassword().trim().equals(AESEncyptionAndDecryption.decrypt(user.getPassword()))) {
				
				user.setPassword(AESEncyptionAndDecryption.encrypt(confirmPwd));
				user.setStatus(ATSConstants.UN_LOCKED);
				service.saveDetails(user);
				
				return mav.addObject("msg", ATSConstants.UNLOCKED_SUCCESS);
			}
			return mav.addObject("msg", ATSConstants.TEMP_PWD_INCORRECT);
		}
		return mav.addObject("msg", ATSConstants.LOGIN_WRONG_EMAIL);
	}
	
	
}
