package com.relation.one2many.controllers;

import com.relation.one2many.entities.Hall;
import com.relation.one2many.entities.University;
import com.relation.one2many.services.HallService;
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
public class HallController {

    @Autowired private HallService hallService;
    @Autowired private UniversityService universityService;

//    All halls page
    @GetMapping("/halls")
    public String r_allHallPage(Model model) {
        model.addAttribute("halls", hallService.findAllHalls());
        return "halls/halls";
    }

//    View one Hall page
    @GetMapping("/halls/{hallId}")
    public String r_viewHall(Model model, @PathVariable("hallId") Long hallId) {
        model.addAttribute("hall", hallService.findHallById(hallId));
        return "halls/hall";
    }

//    New Hall Form
    @GetMapping("/halls/new")
    public String r_newHallForm(Model model) {
        List<University> universities = universityService.findAllUniversities();
        model.addAttribute("hall", new Hall());
        model.addAttribute("universities", universities);
        return "halls/hall_form";
    }

//    Edit Hall Form
    @GetMapping("/halls/{hallId}/edit")
    public String r_editHallForm(Model model, @PathVariable("hallId") Long hallId) {
        model.addAttribute("hall", hallService.findHallById(hallId));
        model.addAttribute("universities", universityService.findAllUniversities());
        return "halls/hall_form";
    }

//    Save Hall
    @PostMapping("/halls/save")
    public String p_saveHall(@Valid Hall hall, BindingResult result, Model model) {
        if (result.hasErrors()) {
//            The next line is to fix the issue that Universities are not appear after submit with hasError()
            model.addAttribute("universities", universityService.findAllUniversities());
            return "halls/hall_form";
        }
        hallService.saveHall(hall);
        return "redirect:/halls";
    }

//    Delete a Hall by id
    @GetMapping("/halls/{hallId}/delete")
    public String p_deleteHallById(@PathVariable("hallId") Long hallId) {
        hallService.deleteHallById(hallId);
        return "redirect:/halls";
    }


}
