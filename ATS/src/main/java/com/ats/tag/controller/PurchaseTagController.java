package com.ats.tag.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ats.constants.ATSConstants;
import com.ats.rto.bindings.VehicleSummary;
import com.ats.rto.model.VehicleDetailsModel;
import com.ats.rto.model.VehicleOwnerAddressDetailsModel;
import com.ats.rto.model.VehicleOwnerDetailsModel;
import com.ats.rto.model.VehicleRegisterDetailsModel;
import com.ats.tag.model.PurchaseTagModel;
import com.ats.tag.service.PurchaseTagServiceImpl;
import com.ats.tag.service.VehicleDetailsService;
import com.ats.util.DateUtil;

/**
 * 
 * @author pavan
 *
 */
@Controller
public class PurchaseTagController {

	@Autowired
	private PurchaseTagServiceImpl purchageTagService;

	@Autowired
	private VehicleDetailsService vehicleDtlsService;

	/**
	 * 
	 * @param session  it is for storing vehicle details in session.
	 * @param vehRegNo based on this vehRegNo we are getting vehicle data.
	 * @return it is returning purchageTag view page
	 */

	@PostMapping("/checkVehRegNo")
	public String checkVehRegNo(HttpSession session, @RequestParam("vehRegNo") String vehRegNo) {

		if (purchageTagService.countByVehicleRegNum(vehRegNo)<1) {

			VehicleSummary vehicleSummary = (VehicleSummary) session.getAttribute("vehlSummary");
			saveVehicleDetails(vehicleSummary);

			return "redirect:/purchaseTag?vehRegNo=" + vehRegNo + "&&" + "vehType="
					+ vehicleSummary.getVehicleDetailModel().getVehicleType();
		}

		return "redirect:/searchVehRegNo?vehRegNo=" + vehRegNo;
	}

	/**
	 * 
	 * @param model    setting PurchageTagModel to this model
	 * @param vehRegNo adding vehRegNo to the model.
	 * @return it is returning the purchaseTag view page
	 */
	@GetMapping("/purchaseTag")
	public String purchaseTagForm(Model model, @RequestParam("vehRegNo") String vehRegNo,
			@RequestParam("vehType") String vehType) {
		PurchaseTagModel purchaseTagModel = new PurchaseTagModel();
		purchaseTagModel.setVehicleRegNum(vehRegNo);
		purchaseTagModel.setVehicleType(vehType);

		model.addAttribute("purchaseTagModel", purchaseTagModel);

		return ATSConstants.PURCHASETAG_VIEW;
	}

	@PostMapping("/purchaseTagDtls")
	public String registerPurchaseTagDtls(@ModelAttribute("purchaseTagModel") PurchaseTagModel tagModel, Model model,
			HttpSession session) {

		Long id = (Long) session.getAttribute("Id");
		Long tagId = purchageTagService.saveDtls(id, tagModel);
		if (tagId != null) {
			return "redirect:" + ATSConstants.RECHARGE_VIEW + "?id=" + tagId;
		}
		model.addAttribute("msg", ATSConstants.TAG_PURCHAGE_FAILURE);
		return ATSConstants.PURCHASETAG_VIEW;
	}

	@GetMapping("/searchVehRegNo")
	public String showSearchVehRegForm(HttpSession session, Model model, @RequestParam("vehRegNo") String vehRegNo)
			throws Exception {
		PurchaseTagModel purchaseTagModel = purchageTagService.findByVehicleRegNumAndTagSwitch(vehRegNo,ATSConstants.TAG_VALID);
		
		if(purchaseTagModel.getTagExpiryDate()!=null)
		if (DateUtil.toDayDate().compareTo(purchaseTagModel.getTagExpiryDate()) <= -1) {
			model.addAttribute("msg", ATSConstants.TAG_MSG);
			return ATSConstants.SEARCH_VEH_REGNO_VIEW;
		}
		VehicleSummary vehicleSummary = (VehicleSummary) session.getAttribute("vehlSummary");

		return "redirect:/purchaseTag?vehRegNo=" + vehRegNo + "&&" + "vehType="
				+ vehicleSummary.getVehicleDetailModel().getVehicleType();

	}

	/**
	 * 
	 * this method is called by checkVehRegNo() method
	 * 
	 * @param vehicleSummary is storing the VehicleSummary details
	 */

	public void saveVehicleDetails(VehicleSummary vehicleSummary) {

		VehicleOwnerDetailsModel vehicleOwnerDetailsModel = vehicleSummary.getVehicleOwnerDetailsModel();
		VehicleOwnerAddressDetailsModel vehicleOwnerAddressDetailsModel = vehicleSummary
				.getVehicleOwnerAddressDetailsModel();
		VehicleDetailsModel vehicleDetailModel = vehicleSummary.getVehicleDetailModel();
		VehicleRegisterDetailsModel vehicleRegisterDetailsModel = vehicleSummary.getVehicleRegisterDetailsModel();

		vehicleDtlsService.saveVehOwnerDtls(vehicleOwnerDetailsModel);
		vehicleDtlsService.saveVehOwnerAddrDtls(vehicleOwnerAddressDetailsModel);
		vehicleDtlsService.saveVehDtls(vehicleDetailModel);
		vehicleDtlsService.saveVehRegDtls(vehicleRegisterDetailsModel);

	}

}
