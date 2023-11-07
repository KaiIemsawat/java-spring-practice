package com.one2many.inventory.controllers;

import com.one2many.inventory.entities.Category;
import com.one2many.inventory.entities.Product;
import com.one2many.inventory.repositories.CategoryRepo;
import com.one2many.inventory.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductRepo prodRepo;

    @Autowired
    private CategoryRepo catRepo;

    @GetMapping("/products/new")
    public String r_productForm(Model model){
        List<Category> categoryList = catRepo.findAll();

        model.addAttribute("product", new Product());
        model.addAttribute("categoriesList", categoryList);

        return "products/product_form";
    }

    @PostMapping("/products/save")
    public String p_saveProduct(Product product) {
        prodRepo.save(product);

        return "redirect:/";
    }
}
