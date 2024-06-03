package com.JavaWeb.HotelManagementSystem.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JavaWeb.HotelManagementSystem.Models.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{
    
}
