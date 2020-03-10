package com.ats.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ats.constants.ATSConstants;
import com.ats.user.model.UserModel;
import com.ats.user.service.UserServiceImpl;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author pavan
 *
 */

@Controller
public class UserLogInController {

	@Autowired
	private UserServiceImpl service;

	@Value("${admin.user}")
	private String userName;

	@Value("${admin.pwd}")
	private String pwd;

	/**
	 * this method is used to show the userLogIn form.
	 * 
	 * @param model
	 * @return
	 */

	@ApiOperation("this operation is used to show the userLogIn form")
	@GetMapping("/login")
	public String logIn(Model model) {

		UserModel userModel = new UserModel();
		model.addAttribute("userModel", userModel);

		return ATSConstants.USER_LOG_IN;

	}

	/**
	 * 
	 * @param userModel
	 * @return
	 */
	@PostMapping("/submit")
	public ModelAndView submit(@ModelAttribute("userModel") UserModel userModel, HttpSession session) {

		ModelAndView mav = new ModelAndView();

		if (userModel.getEmail().trim().equals(userName) && userModel.getPassword().trim().equals(pwd)) {
			mav.setViewName(ATSConstants.ADMIN.toLowerCase());
			return mav;
		} else {

			if (service.existsByEmail(userModel.getEmail())) {
				return mav = service.validateLogIn(userModel, session);
			}
			mav.setViewName(ATSConstants.USER_LOG_IN);
			mav.addObject("msg", ATSConstants.LOGIN_WRONG_EMAIL);
		}
		return mav;
	}

}
