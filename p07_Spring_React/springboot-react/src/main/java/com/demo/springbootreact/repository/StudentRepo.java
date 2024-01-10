package com.demo.springbootreact.repository;

import com.demo.springbootreact.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student, Long> {
    Optional<Student> findByEmail(String email);
}
