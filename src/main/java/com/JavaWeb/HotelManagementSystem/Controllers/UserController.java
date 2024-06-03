package com.JavaWeb.HotelManagementSystem.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.JavaWeb.HotelManagementSystem.Models.User;
import com.JavaWeb.HotelManagementSystem.Services.UserService;

@RequestMapping("/User")
@Controller 

public class UserController {
    @Autowired
    private UserService UserService;

    @GetMapping({"/", ""})
    public String showUserS(Model model) {
        model.addAttribute("UserList",UserService.findAll());
        return "User";
    }

    @GetMapping("/{id}/edit")
    public String editUserForm(@PathVariable("id") Long UserId, Model model) {
        User User = UserService.getUserById(UserId);
        model.addAttribute("User", User);
        return "editCon";
    }

    @PostMapping("/{id}/update")
    public String updateUser(@PathVariable("id") Long UserId, @ModelAttribute("User") User updatedUser, Model model) {
        UserService.updateUser(UserId, updatedUser);
        model.addAttribute("UserList",UserService.findAll());
        return "User";
    }


    @PostMapping("/save-project")
    public String saveUser(@ModelAttribute User User, Model model) {
   	    UserService.saveUser(User);
        model.addAttribute("UserList",UserService.findAll());
    	return "User";
    }

    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") Long UserId, Model model) {
        System.out.println(UserId);
        UserService.deleteUser(UserId);
        model.addAttribute("UserList",UserService.findAll());
        return "User"; // Redirect to the User list page
    }
}
