package com.relation.one2many.repositories;

import com.relation.one2many.entities.Hall;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HallRepo extends CrudRepository<Hall, Long> {
    List<Hall> findAll();

    List<Hall> findAllByOrderByHallNameDesc();
}
