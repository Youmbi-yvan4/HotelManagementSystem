package com.JavaWeb.HotelManagementSystem.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChaosController {
    @GetMapping({ "/login","" })
    public String login() {
        return "login";
    }

    @GetMapping({ "/register"})
    public String Signup() {
        return "register";
    }

    @GetMapping({ "/home"})
    public String home() {
        return "home";
    }
}
