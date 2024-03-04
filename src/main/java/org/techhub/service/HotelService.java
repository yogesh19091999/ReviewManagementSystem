package org.techhub.service;

import org.Model.HotelInfoModel;
import org.Model.HotelModel;
import org.techhub.repository.HotelRepository;
import java.util.*;
public class HotelService {
	HotelRepository hotelRepo = new HotelRepository();
	public boolean isAddHotel(HotelModel model)
	{
		return hotelRepo.isAddHotel(model);
	}
	public List<HotelModel>getAllHotels(){
		return hotelRepo.getAllHotes();
	}
	public boolean isDeleteHotel(int hotelid) {
		return hotelRepo.isDeleteHotel(hotelid);
	}
	public boolean isUpdateHotel(HotelModel model) {
		return hotelRepo.isHotelUpdate(model);
	}
	public boolean isAddHotelInfo(HotelInfoModel  model) {
		return hotelRepo.isAddHotelInfo(model);
	}
	public List<HotelInfoModel> getHotelList(){
		return hotelRepo.getHotelInfo();
	}
}
