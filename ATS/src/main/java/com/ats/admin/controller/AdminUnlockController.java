package com.ats.admin.controller;

import javax.servlet.http.HttpServletRequest;

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
public class AdminUnlockController {
	
	@Autowired
   public AdminService service;

	@GetMapping("/adminUnLock")
	public String unLockForm(@RequestParam("email")String email,Model model) {
		
		UserModel userModel=new UserModel();
		userModel.setEmail(email);
		model.addAttribute("userModel", userModel);
		
		return ATSConstants.ADMIN_UN_LOCK;
	}
	
	@PostMapping("/unLockAdminAccount")
	public ModelAndView unLock(@ModelAttribute("userModel") UserModel model,HttpServletRequest req) {
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName(ATSConstants.ADMIN_UN_LOCK);
		
		String confirmPwd = req.getParameter("pwd");
		String unLockAccount = service.unLockAccount(model,confirmPwd);		
		mav.addObject("msg", unLockAccount);
		
		return mav;
	}
	
	
}
