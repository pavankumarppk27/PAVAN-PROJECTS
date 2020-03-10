package com.ats.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.admin.repository.AdminRepository;
import com.ats.constants.ATSConstants;
import com.ats.user.entity.UserEntity;
import com.ats.user.model.UserModel;
import com.ats.user.repository.UserRepository;
import com.ats.util.AESEncyptionAndDecryption;
import com.ats.util.EmailFileReader;
import com.ats.util.EmailService;
import com.ats.util.TemporaryPwdAndId;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private EmailService emailService;

	@Override
	public boolean saveDtls(UserModel model) {
		// TODO Auto-generated method stub

		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(model, userEntity);
		if (model.getActiveSwitch() == null) {
			userEntity.setActiveSwitch("Y");
		}
		if (model.getStatus() == null) {
			userEntity.setStatus(ATSConstants.LOCKED);
		}
		if (model.getPassword() == null) {
			String generateTempPwd = TemporaryPwdAndId.generateTempPwd();
			userEntity.setPassword(generateTempPwd);
			sendMail(ATSConstants.ADMIN_UNLOCK_URL, userEntity);
			userEntity.setPassword(AESEncyptionAndDecryption.encrypt(generateTempPwd));
		}
		UserEntity save = adminRepo.save(userEntity);

		return save.getUserId() != null;
	}

	public void sendMail(String URL, UserEntity userEntity) {
		String textMsg = null;
		try {
			// getting email body from EmailFileReader Class
			textMsg = EmailFileReader.readMailBody(URL, userEntity);
			// calling EmailService class
			emailService.sendEmail(textMsg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public String unLockAccount(UserModel model, String pwd) {
		// TODO Auto-generated method stub
		if (userRepo.existsByEmail(model.getEmail())) {
			UserEntity user = userRepo.findByEmail(model.getEmail());
			if (model.getPassword().trim().equals(AESEncyptionAndDecryption.decrypt(user.getPassword()))) {

				user.setStatus(ATSConstants.UN_LOCKED);
				user.setPassword(AESEncyptionAndDecryption.encrypt(pwd));
				BeanUtils.copyProperties(user, model);
				saveDtls(model);

				return ATSConstants.UNLOCKED_SUCCESS;
			}
			return ATSConstants.TEMP_PWD_INCORRECT;
		}
		return ATSConstants.LOGIN_WRONG_EMAIL;
	}

	

	@Override
	public void activeAccount(String email) {
		// TODO Auto-generated method stub

		UserModel userModel = findByEmail(email);
		userModel.setActiveSwitch("Y");
		saveDtls(userModel);

	}

	@Override
	public void DeActiveAccount(String email) {
		// TODO Auto-generated method stub

		UserModel userModel = findByEmail(email);
		userModel.setActiveSwitch("N");
		saveDtls(userModel);

	}

	@Override
	public UserModel findByEmail(String email) {
		// TODO Auto-generated method stub

		UserEntity userEntity = userRepo.findByEmail(email);
		UserModel userModel = new UserModel();
		BeanUtils.copyProperties(userEntity, userModel);

		return userModel;
	}
	
	@Override
	public List<UserModel> getAccountsDtls(String user,String role) {
		// TODO Auto-generated method stub

		List<UserEntity> listUserEntity = adminRepo.findAllAgencyAccounts(user,role);
		List<UserModel> listAdminModel = new ArrayList<UserModel>();
		for (UserEntity entity : listUserEntity) {

			UserModel adminModel = new UserModel();
			BeanUtils.copyProperties(entity, adminModel);
			listAdminModel.add(adminModel);
		}

		return listAdminModel;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
