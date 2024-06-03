package com.JavaWeb.HotelManagementSystem.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JavaWeb.HotelManagementSystem.Models.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
