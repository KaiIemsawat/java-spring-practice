package com.javaspringboot.one2many.repositories;

import com.javaspringboot.one2many.enitiy.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepo extends JpaRepository<Brand, Integer> {
}
