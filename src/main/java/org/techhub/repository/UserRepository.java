package org.techhub.repository;

import org.Model.LoginModel;
import org.Model.RegisterModel;

public class UserRepository extends DBConfig{
	
	public boolean isRegisterUser(RegisterModel model) {
		try {
			stmt=conn.prepareStatement("insert into userreg values('0',?,?,?,?,?)");
			stmt.setString(1, model.getName());
			stmt.setString(2, model.getEmail());
			stmt.setString(3, model.getContact());
			stmt.setString(4, model.getUsername());
			stmt.setString(5, model.getPassword());
			int value=stmt.executeUpdate();
			return value>0?true:false;
		}
		catch(Exception ex) {
			System.out.println("Error is"+ex);
			return false;
		}
	}
	public int validateUser(LoginModel model) {
		try {
			stmt=conn.prepareStatement("select * from userreg where username=? and password=?");
			stmt.setString(1, model.getUsername());
			stmt.setString(2, model.getPassword());
			rs=stmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			else {
				return -1;
			}
		}
		catch(Exception ex) {
			System.out.println("Error is"+ex);
			return -1;
		}
		
	}
	public RegisterModel getUserProfile(int loginUserid) {
		try {
			stmt=conn.prepareStatement("select * from userreg where rid=?");
			stmt.setInt(1, loginUserid);
			rs=stmt.executeQuery();
			if(rs.next()) {
				RegisterModel model=new RegisterModel();
				model.setName(rs.getString("name"));
				model.setEmail(rs.getString("email"));
				model.setContact(rs.getString("contact"));
				model.setUsername(rs.getString("username"));
				model.setPassword(rs.getString("password"));
				return model;
				
			}
			else {
				return null;
			}
		}
		catch(Exception ex) {
			System.out.println("eror is"+ex);
			return null;
		}
	}

}
