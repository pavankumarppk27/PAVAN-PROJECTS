package com.tagtransaction.restcontntroller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tagtransaction.bindings.TagTxRequestBindings;
import com.tagtransaction.bindings.TagTxResponseBindings;
import com.tagtransaction.model.TagTxRequestModel;
import com.tagtransaction.model.TagTxResponseModel;
import com.tagtransaction.service.TagTransactionServiceImpl;

@RestController
public class TagTransactionRestController {

	@Autowired
	private TagTransactionServiceImpl service;

	@PostMapping(value = "/tagTx", consumes = "application/xml", produces = "application/xml")

	public TagTxResponseBindings tagTransaction(@RequestBody TagTxRequestBindings tagTxReq) {

		TagTxResponseBindings tagTxResp = new TagTxResponseBindings();

		TagTxRequestModel txReqModel = new TagTxRequestModel();
		BeanUtils.copyProperties(tagTxReq, txReqModel);
		TagTxResponseModel tagTxResponseModel = service.validateTransactionOfVehicle(txReqModel);
		BeanUtils.copyProperties(tagTxResponseModel, tagTxResp);

		return tagTxResp;
	}

	@GetMapping(value = "/get", consumes = "application/xml", produces = "application/xml")
	public TagTxRequestBindings get() {

		TagTxRequestBindings tag = new TagTxRequestBindings();

		tag.setTollPlazaId("TT1001");
		tag.setTollAmt(100D);
		tag.setTagRegId("TRGId");
		tag.setVehRegNum("VEG1001");

		return tag;
	}

}
