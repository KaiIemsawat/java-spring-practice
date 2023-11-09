package com.college.demo.controllers;

import com.college.demo.entities.University;
import com.college.demo.services.UniversityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
        return "universities/universities";
    }

    @GetMapping("/universities/new")
    public String r_newUniversityForm(Model model) {
        model.addAttribute("university", new University());
        return "universities/university_form";
    }

    @PostMapping("/universities/save")
    public String p_saveUniversity(@Valid University university, BindingResult result) {
        if (result.hasErrors()) {
            return "universities/university_form"; // Do not use 'redirect' !!
        }
        universityService.saveUniversity(university);
        return "redirect:/universities";
    }
}
