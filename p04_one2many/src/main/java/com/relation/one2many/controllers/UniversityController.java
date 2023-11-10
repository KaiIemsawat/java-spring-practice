package com.relation.one2many.controllers;

import com.relation.one2many.entities.University;
import com.relation.one2many.services.UniversityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UniversityController {
    @Autowired
    private UniversityService universityService;

    @GetMapping("/")
    public String homeRoute() {
        return "redirect:/universities";
    }

//    Render all universities
    @GetMapping("/universities")
    public String r_allUniversities(Model model) {
        List<University> universities = universityService.findAllUniversities();
        model.addAttribute("universities", universities);
        return "universities/universities";
    }

//    Render a university
    @GetMapping("/universities/{university_id}")
    public String r_viewUniversity(Model model, @PathVariable("university_id") Long university_id) {
        model.addAttribute(universityService.findUniversityById(university_id));
        return "universities/university";
    }

//    Render add university form
    @GetMapping("/universities/new")
    public String r_newUniversityForm(Model model) {
        model.addAttribute("university", new University());
        return "universities/university_form";
    }

//    Render edit university form
    @GetMapping("universities/{university_id}/edit")
    public String r_editUniversityForm(@PathVariable("university_id") Long university_id, Model model) {
        model.addAttribute("university", universityService.findUniversityById(university_id));
        return "universities/university_form";
    }

//    Save university
    @PostMapping("/universities/save")
    public String p_saveUniversity(@Valid University university, BindingResult result) {
        if (result.hasErrors()) {
            return "universities/university_form"; // Do not use 'redirect' !!
        }
        universityService.saveUniversity(university);
        return "redirect:/universities";
    }

//    Delete a university by id
//    @DeleteMapping("/universities/{university_id}/delete") // Use @DeleteMapping if using <button> in <form> with hidden <input>
    @GetMapping("/universities/{university_id}/delete") // Use @GetMapping if using <a> tag for deleting
    public String p_deleteUniversityById(@PathVariable("university_id") Long university_id) {
        universityService.deleteUniversity(university_id);
        return "redirect:/universities";
    }
}
