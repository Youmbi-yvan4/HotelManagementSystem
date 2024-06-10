package com.JavaWeb.HotelManagementSystem.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.JavaWeb.HotelManagementSystem.Models.User;
import com.JavaWeb.HotelManagementSystem.Repositories.UserRepository;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository URepo;

    @Override
    public User saveUser(User User) {
        return URepo.save(User);
    }

    @Override
    public List<User> findAll() {
        return URepo.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return URepo.findById(id).orElseThrow();
    }

    @Override
    public void updateUser(Long id, User updatedUser) {
        User existingUser = getUserById(id);
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setReservations(updatedUser.getReservations());
        existingUser.setUsername(updatedUser.getUsername());

        URepo.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        URepo.deleteById(id);
    }
}
