package com.spring.p01_company.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("")
    public String showHomepage() {
        System.out.println("Main controller");
        return "index";
    }
}
