package com.JavaWeb.HotelManagementSystem.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.JavaWeb.HotelManagementSystem.Models.Room;
import com.JavaWeb.HotelManagementSystem.Services.RoomService;

@RequestMapping("/Room")
@Controller

public class RoomController {
    
    @Autowired
    private RoomService RoomService;

    @GetMapping({"/", ""})
    public String showRoomS(Model model) {
        model.addAttribute("RoomList",RoomService.findAll());
        return "Room";
    }

    @GetMapping("/{id}/edit")
    public String editRoomForm(@PathVariable("id") Long RoomId, Model model) {
        Room Room = RoomService.getRoomById(RoomId);
        model.addAttribute("Room", Room);
        return "editCon";
    }

    @PostMapping("/{id}/update")
    public String updateRoom(@PathVariable("id") Long RoomId, @ModelAttribute("Room") Room updatedRoom, Model model) {
        RoomService.updateRoom(RoomId, updatedRoom);
        model.addAttribute("RoomList",RoomService.findAll());
        return "Room";
    }


    @PostMapping("/save-project")
    public String saveRoom(@ModelAttribute Room Room, Model model) {
   	    RoomService.saveRoom(Room);
        model.addAttribute("RoomList",RoomService.findAll());
    	return "Room";
    }

    @GetMapping("/{id}/delete")
    public String deleteRoom(@PathVariable("id") Long RoomId, Model model) {
        System.out.println(RoomId);
        RoomService.deleteRoom(RoomId);
        model.addAttribute("RoomList",RoomService.findAll());
        return "Room"; // Redirect to the Room list page
    }
}
