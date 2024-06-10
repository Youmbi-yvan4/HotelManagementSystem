package com.JavaWeb.HotelManagementSystem.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.JavaWeb.HotelManagementSystem.Models.Hotel;
import com.JavaWeb.HotelManagementSystem.Repositories.HotelRepository;

import org.springframework.stereotype.Service;
@Service
public class HotelServiceImp implements HotelService {
    @Autowired
    private HotelRepository HRepo;

    @Override
    public Hotel saveHotel(Hotel Hotel) {
        return HRepo.save(Hotel);
    }

    @Override
    public List<Hotel> findAll() {
        return HRepo.findAll();
    }

    @Override
    public Hotel getHotelById(Long id) {
        return HRepo.findById(id).orElseThrow();
    }

    @Override
    public void updateHotel(Long id, Hotel updatedHotel) {
        Hotel existingHotel = getHotelById(id);
        existingHotel.setName(updatedHotel.getName());
        existingHotel.setLocation(updatedHotel.getLocation());
        existingHotel.setRooms(updatedHotel.getRooms());
        existingHotel.setAmenities(updatedHotel.getAmenities());

        HRepo.save(existingHotel);
    }

    @Override
    public void deleteHotel(Long id) {
        HRepo.deleteById(id);
    }

}
