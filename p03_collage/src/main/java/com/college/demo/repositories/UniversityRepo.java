package com.college.demo.repositories;

import com.college.demo.entities.University;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversityRepo extends CrudRepository<University, Long> {
    List<University> findAll();

}
