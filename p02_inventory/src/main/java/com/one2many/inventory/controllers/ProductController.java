package com.one2many.inventory.controllers;

import com.one2many.inventory.entities.Category;
import com.one2many.inventory.entities.Product;
import com.one2many.inventory.repositories.CategoryRepo;
import com.one2many.inventory.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductRepo prodRepo;

    @Autowired
    private CategoryRepo catRepo;

    @GetMapping("/products")
    public String r_productsList(Model model) {
        List<Product> productsList = prodRepo.findAll();
        model.addAttribute("products", productsList);
        return "products/products";
    }

    @GetMapping("/products/new")
    public String r_productForm(Model model){
        List<Category> categoryList = catRepo.findAll();

        model.addAttribute("product", new Product());
        model.addAttribute("categoriesList", categoryList);

        return "products/product_form";
    }

    @GetMapping("/products/edit/{prod_id}")
    public String r_editProductForm(@PathVariable("prod_id") Integer prod_id, Model model) {
        Product product = prodRepo.findById(prod_id).get();
        model.addAttribute("product", product);

//        Need these lines for 'categories' select dropdown menu
        List<Category> categoryList = catRepo.findAll();
        model.addAttribute("categoriesList", categoryList);

        return "products/product_form";
    }

    @PostMapping("/products/save")
    public String p_saveProduct(Product product) {
        prodRepo.save(product);

        return "redirect:/products";
    }

    @GetMapping("products/delete/{prod_id}")
    public String p_deleteProduct(@PathVariable("prod_id") Integer prod_id){
        prodRepo.deleteById(prod_id);
        return "redirect:/products";
    }
}
