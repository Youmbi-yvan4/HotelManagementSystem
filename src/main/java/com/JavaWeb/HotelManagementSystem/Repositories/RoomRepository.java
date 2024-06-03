package com.JavaWeb.HotelManagementSystem.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JavaWeb.HotelManagementSystem.Models.Room;

public interface RoomRepository extends JpaRepository<Room, Long>{
    
}