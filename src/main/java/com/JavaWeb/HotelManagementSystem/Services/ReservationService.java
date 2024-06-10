package com.JavaWeb.HotelManagementSystem.Services;

import java.util.List;

import com.JavaWeb.HotelManagementSystem.Models.Reservation;

public interface ReservationService {

	Reservation saveReservation(Reservation reservation);

	List<Reservation> findAll();

	Reservation getReservationById(Long id);

	void updateReservation(Long id, Reservation updatedReservation);

	void deleteReservation(Long id);
}
