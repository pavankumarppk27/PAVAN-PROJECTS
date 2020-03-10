package com.ats.user.service;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.ats.user.model.UserModel;

public interface UserService {
	
	public boolean saveDetails(UserModel userModel);
	public UserModel findByEmail(String password);
    public ModelAndView validateLogIn(UserModel userModel,HttpSession session);
    public boolean existsByEmail(String email);
    public void getForGetPwd(String email);
    


}
