package com.JavaWeb.HotelManagementSystem.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.JavaWeb.HotelManagementSystem.Models.Reservation;
import com.JavaWeb.HotelManagementSystem.Repositories.ReservationRepository;

public class ReservationServiceImp implements ReservationService{
    
    @Autowired
    private ReservationRepository ReRepo;

    @Override
    public Reservation saveReservation(Reservation reservation) {
        return ReRepo.save(reservation);
    }

    @Override
    public List<Reservation> findAll() {
        return ReRepo.findAll();
    }

    @Override
    public Reservation getReservationById(Long id) {
        return ReRepo.findById(id).orElseThrow();
    }

    @Override
    public void updateReservation(Long id, Reservation updatedReservation) {
        Reservation existingReservation = getReservationById(id);
        existingReservation.setUser(updatedReservation.getUser());
        existingReservation.setRoom(updatedReservation.getRoom());
        existingReservation.setCheckInDate(updatedReservation.getCheckInDate());
        existingReservation.setCheckOutDate(updatedReservation.getCheckOutDate());

        ReRepo.save(existingReservation);
    }

    @Override
    public void deleteReservation(Long id) {
        ReRepo.deleteById(id);
    }

}