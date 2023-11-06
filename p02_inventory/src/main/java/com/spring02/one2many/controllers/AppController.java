package com.spring02.one2many.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/")
    public String viewHomepage() {
        return "index";
    }


}
