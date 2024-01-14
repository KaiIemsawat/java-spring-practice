package com.javaspringboot.one2many.controllers;

import com.javaspringboot.one2many.enitiy.Category;
import com.javaspringboot.one2many.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepo categoryRepo;

    @GetMapping("/categories")
    public String listCategories(Model model) {
        List<Category> listCategories = categoryRepo.findAll();

        model.addAttribute("listCategories", listCategories);
        return "categories/categories";
    }

    @GetMapping("/categories/new")
    public String showCreateNewCategoryForm(Model model) {
        model.addAttribute("category", new Category());

        return "categories/category_form";
    }
}
