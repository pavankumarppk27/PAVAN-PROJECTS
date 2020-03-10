package com.ats.tag.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ats.constants.ATSConstants;
import com.ats.tag.model.PurchaseTagModel;
import com.ats.tag.service.PurchaseTagServiceImpl;

@Controller
public class RechargeBalanceController {
	
	@Autowired
	private PurchaseTagServiceImpl purchageTagService;

	@GetMapping("/recharge")
	public String recharge(@RequestParam("id") Long id,Model model) {
		
		model.addAttribute("msg", ATSConstants.TAG_PURCHAGE_SUCCESS);
		model.addAttribute("id", id);
		
		return "recharge";
	}
	
	@PostMapping("/rechargeBalance")
	public String rechargeBalance(@RequestParam("id") Long tagId,HttpServletRequest req,Model model,HttpSession session) {
		
		Long id = (Long) session.getAttribute("Id");		
		PurchaseTagModel purchaseModel = purchageTagService.findById(tagId);
		Double tagBal= Double.parseDouble(req.getParameter("balance"));	
		purchaseModel.setTagBal(tagBal);
		Long purchaseTagId=purchageTagService.saveRechargeDtls(id,purchaseModel);

			
		if(purchaseTagId!=null) {
			model.addAttribute("msg",ATSConstants.TAG_RECHARGE_SUCCESS);
			return "recharge";
		}
		model.addAttribute("msg",ATSConstants.TAG_RECHARGE_FAILURE);

		return "recharge";
	}
}
