package com.ats.admin.service;

import java.util.List;

import com.ats.user.model.UserModel;

public interface AdminService {
	
	
	public boolean saveDtls(UserModel model);	
	public String unLockAccount(UserModel model,String pwd);
	
	public void activeAccount(String email);
	public void DeActiveAccount(String email);
	public UserModel findByEmail(String email);
	
	public List<UserModel> getAccountsDtls(String user,String role);
	

	
	

}
