package com.ats.tag.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ats.constants.ATSConstants;
import com.ats.tag.model.PurchaseTagModel;
import com.ats.tag.service.PurchaseTagServiceImpl;

@Controller
public class ViewTagsController {

	@Autowired
	private PurchaseTagServiceImpl service;

	@GetMapping("/viewTags")
	public ModelAndView viewTags(HttpSession session) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName(ATSConstants.VIEWTAGS_VIEW);

		Long id = (Long) session.getAttribute("Id");

		if (id != null) {
			List<PurchaseTagModel> listPurchaseTagModel = service.findByUserId(id);
			mav.addObject("listTagDtls", listPurchaseTagModel);
			return mav;
		}
		mav.addObject("msg",ATSConstants.NO_TAGS);

		return mav;
	}

}
