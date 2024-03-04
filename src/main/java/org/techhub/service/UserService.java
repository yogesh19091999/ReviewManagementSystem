package org.techhub.service;

import org.Model.LoginModel;
import org.Model.RegisterModel;
import org.techhub.repository.UserRepository;

public class UserService {
	UserRepository userRepo=new UserRepository();
	public boolean isRegisterUser(RegisterModel model) {
		return userRepo.isRegisterUser(model);
	}
	public int validateUser(LoginModel model) {
		return userRepo.validateUser(model);
	}
	public RegisterModel getUserProfile(int userid) {
		return userRepo.getUserProfile(userid);
	}
}
