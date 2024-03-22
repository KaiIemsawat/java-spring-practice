package com.demo.springbootReact.repositories;

import com.demo.springbootReact.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student, Long> {
    Optional<Student> findByEmail(String email);
}
