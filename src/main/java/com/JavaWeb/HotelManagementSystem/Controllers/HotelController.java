package com.JavaWeb.HotelManagementSystem.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.JavaWeb.HotelManagementSystem.Models.Hotel;
import com.JavaWeb.HotelManagementSystem.Services.HotelService;

@RequestMapping("/Hotel")
@Controller
public class HotelController {
    
    @Autowired
    private HotelService HotelService;

    @GetMapping({"/", ""})
    public String showHotelS(Model model) {
        model.addAttribute("HotelList",HotelService.findAll());
        return "Hotel";
    }

    @GetMapping("/{id}/edit")
    public String editHotelForm(@PathVariable("id") Long HotelId, Model model) {
        Hotel Hotel = HotelService.getHotelById(HotelId);
        model.addAttribute("Hotel", Hotel);
        return "editCon";
    }

    @PostMapping("/{id}/update")
    public String updateHotel(@PathVariable("id") Long HotelId, @ModelAttribute("Hotel") Hotel updatedHotel, Model model) {
        HotelService.updateHotel(HotelId, updatedHotel);
        model.addAttribute("HotelList",HotelService.findAll());
        return "Hotel";
    }


    @PostMapping("/save-project")
    public String saveHotel(@ModelAttribute Hotel Hotel, Model model) {
   	    HotelService.saveHotel(Hotel);
        model.addAttribute("HotelList",HotelService.findAll());
    	return "Hotel";
    }

    @GetMapping("/{id}/delete")
    public String deleteHotel(@PathVariable("id") Long HotelId, Model model) {
        System.out.println(HotelId);
        HotelService.deleteHotel(HotelId);
        model.addAttribute("HotelList",HotelService.findAll());
        return "Hotel"; // Redirect to the Hotel list page
    }
	
}
