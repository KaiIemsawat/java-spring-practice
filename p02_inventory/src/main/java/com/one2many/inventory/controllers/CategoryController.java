package com.one2many.inventory.controllers;

import com.one2many.inventory.entities.Category;
import com.one2many.inventory.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepo catRepo;

    @GetMapping("/categories")
    public String categoriesList(Model model) {
        List<Category> categories = catRepo.findAll();
        model.addAttribute("categories", categories);
        System.out.println(categories);
        return "categories/categories";
    }
}
