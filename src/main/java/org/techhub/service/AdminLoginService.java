package org.techhub.service;

import org.Model.LoginModel;
import org.techhub.repository.AdminLoginRepository;

public class AdminLoginService {
	AdminLoginRepository adRepo = new AdminLoginRepository();
	
	public boolean isAdminLogin(LoginModel model) {
		return adRepo.isAdminLogin(model);
	}

}
