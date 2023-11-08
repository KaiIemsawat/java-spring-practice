package com.college.demo.controllers;

import com.college.demo.services.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UniversityController {
    @Autowired
    private UniversityService universityService;

    @GetMapping("/")
    public String homeRoute() {
        return "redirect:/universities";
    }

    @GetMapping("/universities")
    public String r_allUniversities() {
        return "universities";
    }
}
