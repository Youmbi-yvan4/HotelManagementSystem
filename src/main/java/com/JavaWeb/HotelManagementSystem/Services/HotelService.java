package com.JavaWeb.HotelManagementSystem.Services;

import java.util.List;

import com.JavaWeb.HotelManagementSystem.Models.Hotel;

public interface HotelService {

	Hotel saveHotel(Hotel hotel);

	List<Hotel> findAll();

	Hotel getHotelById(Long id);

	void updateHotel(Long id, Hotel updatedHotel);

	void deleteHotel(Long id);
}
