package org.techhub.service;
import java.util.*;

import org.Model.CityModel;
import org.techhub.repository.CityRepository;
public class CityService {
	CityRepository cityRepo = new CityRepository();
	public boolean isAddCity(CityModel model)
	{
		return cityRepo.isAddCity(model);
	}
	public List<CityModel> getAllCities(){
			return cityRepo.getAllCities();
	}
}
