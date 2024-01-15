package com.javaspringboot.one2many.controllers;

import com.javaspringboot.one2many.enitiy.Category;
import com.javaspringboot.one2many.enitiy.Product;
import com.javaspringboot.one2many.repositories.CategoryRepo;
import com.javaspringboot.one2many.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    @GetMapping("/products/new")
    public String showCreateNewProductFrom(Model model) {
        List<Category> listCategories = categoryRepo.findAll();

        model.addAttribute("product", new Product());
        model.addAttribute("listCategories", listCategories);

        return "products/product_form";
    }

    @PostMapping("/products/save")
    public String saveProduct(Product product) {
        productRepo.save(product);

        return "redirect:/";
    }

}
