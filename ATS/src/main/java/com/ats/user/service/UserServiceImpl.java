package com.ats.user.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.ats.constants.ATSConstants;
import com.ats.user.entity.UserEntity;
import com.ats.user.model.UserModel;
import com.ats.user.repository.UserRepository;
import com.ats.util.AESEncyptionAndDecryption;
import com.ats.util.EmailFileReader;
import com.ats.util.EmailForgotPwdFileReader;
import com.ats.util.EmailService;
import com.ats.util.TemporaryPwdAndId;

/**
 * 
 * @author pavan
 *
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;

	@Autowired
	private EmailService emailService;

	@Override
	public boolean saveDetails(UserModel userModel) {
		// TODO Auto-generated method stub

		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userModel, userEntity);
		// setting user status
		if (userModel.getStatus() == null) {
			userEntity.setStatus(ATSConstants.LOCKED);
		}
		// setting user role
		userEntity.setRole(ATSConstants.USER);

		if (userModel.getActiveSwitch() == null) {
			userEntity.setActiveSwitch("Y");
		}
		// setting user password
		if (userModel.getPassword() == null) {

			String generateRegisterNumber = TemporaryPwdAndId.generateTempPwd();
			userEntity.setPassword(generateRegisterNumber);
			// calling sendMail method
			sendMail(ATSConstants.USER_UNLOCK_URL, userEntity);
			userEntity.setPassword(AESEncyptionAndDecryption.encrypt(generateRegisterNumber));

		}
		UserEntity userLogInEntity = repo.save(userEntity);

		return userLogInEntity.getUserId() != null;
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
	public UserModel findByEmail(String email) {
		// TODO Auto-generated method stub
		UserModel userModel = new UserModel();
		UserEntity userEntity = repo.findByEmail(email);
		BeanUtils.copyProperties(userEntity, userModel);

		return userModel;
	}

	@Override
	public ModelAndView validateLogIn(UserModel userModel,HttpSession session) {
		// TODO Auto-generated method stub
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName(ATSConstants.USER_LOG_IN);
		UserEntity entity = repo.findByEmail(userModel.getEmail());
		
		if (entity.getEmail().equals(userModel.getEmail())
				&& AESEncyptionAndDecryption.decrypt(entity.getPassword()).equals(userModel.getPassword())) {
			if (entity.getStatus().equals("UN_LOCKED")) {
				if (entity.getActiveSwitch().equals("Y")) {
					mav.setViewName(entity.getRole().toLowerCase());				
					session.setAttribute("Id",entity.getUserId());
					return mav;
				}
				mav.addObject("msg", ATSConstants.IN_ACTIVE);
				return mav;
			}
			mav.addObject("msg", ATSConstants.UNLOCK_FAILURE);
			return mav;
		}
		mav.addObject("msg", ATSConstants.LOGIN_FILURE);
		return mav;
	}
	

	@Override
	public boolean existsByEmail(String email) {
		// TODO Auto-generated method stub
		return repo.existsByEmail(email);
	}

	@Override
	public void getForGetPwd(String email) {

		UserEntity userEntity = repo.findByEmail(email);
		userEntity.setPassword(AESEncyptionAndDecryption.decrypt(userEntity.getPassword()));
		String textMsg = null;
		try {
			// getting email body from EmailFileReader Class
			textMsg = EmailForgotPwdFileReader.readMailBody(userEntity);
			// calling EmailService class
			emailService.sendEmail(textMsg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
