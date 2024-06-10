package com.JavaWeb.HotelManagementSystem.Services;

import java.util.List;

import com.JavaWeb.HotelManagementSystem.Models.User;

public interface UserService {
    User saveUser(User User);

    List<User> findAll();

    User getUserById(Long id);

    void updateUser(Long id, User updatedUser);

    void deleteUser(Long id);
}
