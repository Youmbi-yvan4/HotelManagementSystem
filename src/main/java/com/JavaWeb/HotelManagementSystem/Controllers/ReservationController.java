package com.JavaWeb.HotelManagementSystem.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.JavaWeb.HotelManagementSystem.Models.Reservation;
import com.JavaWeb.HotelManagementSystem.Services.ReservationService;

@RequestMapping("/Reservation")
@Controller

public class ReservationController {
    @Autowired
    private ReservationService ReservationService;

    @GetMapping({"/", ""})
    public String showReservationS(Model model) {
        model.addAttribute("ReservationList",ReservationService.findAll());
        return "Reservation";
    }

    @GetMapping("/{id}/edit")
    public String editReservationForm(@PathVariable("id") Long ReservationId, Model model) {
        Reservation Reservation = ReservationService.getReservationById(ReservationId);
        model.addAttribute("Reservation", Reservation);
        return "editCon";
    }

    @PostMapping("/{id}/update")
    public String updateReservation(@PathVariable("id") Long ReservationId, @ModelAttribute("Reservation") Reservation updatedReservation, Model model) {
        ReservationService.updateReservation(ReservationId, updatedReservation);
        model.addAttribute("ReservationList",ReservationService.findAll());
        return "Reservation";
    }


    @PostMapping("/save-project")
    public String saveReservation(@ModelAttribute Reservation Reservation, Model model) {
   	    ReservationService.saveReservation(Reservation);
        model.addAttribute("ReservationList",ReservationService.findAll());
    	return "Reservation";
    }

    @GetMapping("/{id}/delete")
    public String deleteReservation(@PathVariable("id") Long ReservationId, Model model) {
        System.out.println(ReservationId);
        ReservationService.deleteReservation(ReservationId);
        model.addAttribute("ReservationList",ReservationService.findAll());
        return "Reservation"; 
    }
}
