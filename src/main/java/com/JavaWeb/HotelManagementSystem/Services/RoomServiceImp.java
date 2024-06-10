package com.JavaWeb.HotelManagementSystem.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.JavaWeb.HotelManagementSystem.Models.Room;
import com.JavaWeb.HotelManagementSystem.Repositories.RoomRepository;

import org.springframework.stereotype.Service;
@Service
public class RoomServiceImp implements RoomService{
      
    @Autowired
    private RoomRepository RoRepo;

    @Override
    public Room saveRoom(Room Room) {
        return RoRepo.save(Room);
    }

    @Override
    public List<Room> findAll() {
        return RoRepo.findAll();
    }

    @Override
    public Room getRoomById(Long id) {
        return RoRepo.findById(id).orElseThrow();
    }

    @Override
    public void updateRoom(Long id, Room updatedRoom) {
        Room existingRoom = getRoomById(id);
        existingRoom.setAmenities(updatedRoom.getAmenities());
        existingRoom.isAvailability();
        existingRoom.setHotel(updatedRoom.getHotel());
        existingRoom.setRate(updatedRoom.getRate());
        existingRoom.setReservations(updatedRoom.getReservations());
        existingRoom.setRoomNumber(updatedRoom.getRoomNumber());
        existingRoom.setRoomType(updatedRoom.getRoomType());
    
        RoRepo.save(existingRoom);
    }

    @Override
    public void deleteRoom(Long id) {
        RoRepo.deleteById(id);
    }
}
