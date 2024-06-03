package com.JavaWeb.HotelManagementSystem.Services;

import java.util.List;

import com.JavaWeb.HotelManagementSystem.Models.Room;

public interface RoomService {
    Room saveRoom(Room room);

    List<Room> findAll();

    Room getRoomById(Long id);

    void updateRoom(Long id, Room updatedRoom);

    void deleteRoom(Long id);
}
