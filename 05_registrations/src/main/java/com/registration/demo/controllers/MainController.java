package com.registration.demo.controllers;

import com.registration.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired private UserService userService;

    @GetMapping("/")
    public String r_loginRegPage() {
        return "";
    }

    @GetMapping("/dashboard")
    public String r_dashboard() {
        return "";
    }

    @PostMapping("/register")
    public String p_registering() {
        return "";
    }

    @PostMapping("/login")
    public String p_loggingIn() {
        return "";
    }

    @GetMapping("/logout")
    public String p_loggingOut() {
        return "";
    }

}
