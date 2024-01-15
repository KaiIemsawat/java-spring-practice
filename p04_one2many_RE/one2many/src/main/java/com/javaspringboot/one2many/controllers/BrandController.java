package com.javaspringboot.one2many.controllers;

import com.javaspringboot.one2many.enitiy.Brand;
import com.javaspringboot.one2many.enitiy.Category;
import com.javaspringboot.one2many.repositories.BrandRepo;
import com.javaspringboot.one2many.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BrandController {

    @Autowired
    private BrandRepo brandRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    @GetMapping("/brands/new")
    public String showCreateNewBrandForm(Model model) {

        List<Category> listCategories = categoryRepo.findAll();

        model.addAttribute("listCategories" , listCategories);
        model.addAttribute("brand", new Brand());
        return "brands/brand_form";
    }

    @PostMapping("/brands/save")
    public String saveBrand(Brand brand) {
        brandRepo.save(brand);

        return "redirect:/brands";
    }

    @GetMapping("/brands")
    public String listBrands(Model model) {
        List<Brand> listBrands = brandRepo.findAll();
        model.addAttribute("listBrands",listBrands);

        return "brands/brands";
    }

    @GetMapping("brands/edit/{id}")
    public String showEditBrandForm(@PathVariable("id") Integer id, Model model) {
        List<Category> listCategories = categoryRepo.findAll();
        Brand brand = brandRepo.findById(id).get();

        model.addAttribute("listCategories", listCategories);
        model.addAttribute("brand", brand);


        return "brands/brand_form";
    }
}
