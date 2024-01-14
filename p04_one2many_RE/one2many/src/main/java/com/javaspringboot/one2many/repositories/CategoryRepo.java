package com.javaspringboot.one2many.repositories;

import com.javaspringboot.one2many.enitiy.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
