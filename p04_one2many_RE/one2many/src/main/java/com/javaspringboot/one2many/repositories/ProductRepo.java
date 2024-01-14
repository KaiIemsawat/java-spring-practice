package com.javaspringboot.one2many.repositories;

import com.javaspringboot.one2many.enitiy.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {
}
