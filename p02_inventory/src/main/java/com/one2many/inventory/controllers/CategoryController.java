package com.one2many.inventory.controllers;

import com.one2many.inventory.entities.Category;
import com.one2many.inventory.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepo catRepo;

    @GetMapping("/categories")
    public String r_categoriesList(Model model) {
        List<Category> categories = catRepo.findAll();
        model.addAttribute("categories", categories);
        return "categories/categories";
    }

    @GetMapping("/categories/new")
    public String r_newCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "categories/category_form";
    }

    @PostMapping("/categories/save")
    public String p_saveCategory(Category category, RedirectAttributes ra) {
        List<Category> categories = catRepo.findAll();

        for (Category cat : categories) {
            if (category.getName().equals(cat.getName())) {
                System.out.println("Name can not be duplicated");
                ra.addFlashAttribute("message", "This category is already exist");
                return "redirect:/categories/new";
            }
        }
            catRepo.save(category);
            return "redirect:/categories";
    }
}
