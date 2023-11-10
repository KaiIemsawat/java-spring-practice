package com.relation.one2many.repositories;

import com.relation.one2many.entities.University;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UniversityRepo extends CrudRepository<University, Long> {
    List<University> findAll();

    List<University> findAllByOrderByUniversityNameDesc();
}
