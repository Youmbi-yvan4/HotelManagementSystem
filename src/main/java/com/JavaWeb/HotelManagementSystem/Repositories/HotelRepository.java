package com.JavaWeb.HotelManagementSystem.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JavaWeb.HotelManagementSystem.Models.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long>
 {
    
}
