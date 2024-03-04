package org.techhub.repository;

import org.Model.LoginModel;

public class AdminLoginRepository extends DBConfig{
	
	public boolean isAdminLogin(LoginModel model) {
		try {
			stmt=conn.prepareStatement("select * from adminlogin where username=? and password=?");
			stmt.setString(1, model.getUsername());
			stmt.setString(2, model.getPassword());
			rs=stmt.executeQuery();
			if(rs.next()) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception ex) {
			System.out.println("Error is"+ex);
			return false;
		}
		
	}

}
