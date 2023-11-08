package com.one2many.inventory.controllers;

import com.one2many.inventory.entities.Brand;
import com.one2many.inventory.entities.Category;
import com.one2many.inventory.repositories.BrandRepo;
import com.one2many.inventory.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BrandController {

    @Autowired
    private BrandRepo brandRepo;

    @Autowired
    private CategoryRepo catRepo;

    @GetMapping("/brands/new")
    public String r_brandForm(Model model) {
        List<Category> categories = catRepo.findAll();
        model.addAttribute("brand", new Brand());
        model.addAttribute("categories", categories);

        return "brands/brand_form";
    }

    @PostMapping("/brands/save")
    public String p_saveBrand(Brand brand) {
        brandRepo.save(brand);
        return "redirect:/";
    }
}
