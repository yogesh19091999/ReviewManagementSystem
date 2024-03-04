package org.techhub.repository;

import java.util.ArrayList;
import java.util.List;

import org.Model.CityModel;

public class CityRepository extends DBConfig {
	
	List<CityModel> cityList = new ArrayList<CityModel>();
	public boolean isAddCity(CityModel model) {
		try {
			stmt=conn.prepareStatement("insert into city values('0',?)");
			stmt.setString(1, model.getName());
			int value=stmt.executeUpdate();
			return value>0?true:false;
		}
		catch(Exception ex) {
			System.out.println("error is"+ex);
			return false;
		}
		
	}
	public List<CityModel> getAllCities(){
		try {
			stmt=conn.prepareStatement("select * from city");
			rs=stmt.executeQuery();
			while(rs.next()) {
				CityModel model=new CityModel();
				model.setId(rs.getInt(1));
				model.setName(rs.getString(2));
				cityList.add(model);
			}
			return cityList;
		}
		catch(Exception ex) {
			System.out.println("Error is"+ex);
			return null;
		}
	}

}
