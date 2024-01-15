package com.spring.datajpa.repositories;

import com.spring.datajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    public List<Student> findByFirstName(String firstName);
}
