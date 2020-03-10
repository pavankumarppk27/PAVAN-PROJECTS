package com.ats.tag.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ats.constants.ATSConstants;
import com.ats.tag.service.UpdateRechargeService;

@Controller
public class UpdateRechargeController {

	@Autowired
	private UpdateRechargeService service;

	@GetMapping("/update")
	public String updateRecharge() {

		return ATSConstants.UPDATE_RECHARGE;
	}

	@PostMapping("/updateRecharge")
	public ModelAndView updateTagRecharge(@RequestParam("tagRegId") String tagRegId,
			@RequestParam("tagBal") Double balance) {

		ModelAndView mav = new ModelAndView();

		if (service.existsByTagRegId(tagRegId)) {
			if (service.updateRecharge(tagRegId, balance)) {
				mav.addObject("msg", ATSConstants.TAG_RECHARGE_SUCCESS);
				mav.setViewName(ATSConstants.UPDATE_RECHARGE);
				return mav;
			}
			mav.addObject("msg", ATSConstants.TAG_UPDATE_RECHARGE_FAILURE);
			mav.setViewName(ATSConstants.UPDATE_RECHARGE);
			return mav;
		}
		mav.addObject("msg", ATSConstants.TAG_REGID_WRONG);
		mav.setViewName(ATSConstants.UPDATE_RECHARGE);
		return mav;
	}

}
