package com.ats.tagtransaction.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ats.constants.ATSConstants;
import com.ats.tag.model.PurchaseTagModel;
import com.ats.tag.service.PurchaseTagServiceImpl;
import com.ats.tagtransaction.model.TagTransactionModel;
import com.ats.tagtransaction.service.TagTxDetailsServiceImpl;

@Controller
public class TagTxDetailsController {

	@Autowired
	private TagTxDetailsServiceImpl txService;
	@Autowired
	private PurchaseTagServiceImpl tagService;

	@GetMapping("tagTxDetails")
	public ModelAndView getTagTxDetails(HttpSession session) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName(ATSConstants.TAG_TX_DTLS_VIEW);

		List<TagTransactionModel> allTxDtlsModel = new ArrayList<TagTransactionModel>();
		;
		List<TagTransactionModel> listTxDtlsModel = null;
		Long id = (Long) session.getAttribute("Id");
		
		if(id==null) {			
			return mav.addObject("msg", ATSConstants.TAG_NO_TX);
		}

		List<PurchaseTagModel> listPurchaseTagModel = tagService.findByUserId(id);

		for (PurchaseTagModel tagModel : listPurchaseTagModel) {

			listTxDtlsModel = txService.getTagTxDetails(tagModel.getTagRegId());
			for (TagTransactionModel tagTxModel : listTxDtlsModel) {
				allTxDtlsModel.add(tagTxModel);
			}
		}

		mav.addObject("allTxDtlsModel", allTxDtlsModel);

		return mav;

	}

}
