package com.relation.one2many.services;

import com.relation.one2many.entities.Hall;
import com.relation.one2many.entities.University;
import com.relation.one2many.repositories.HallRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HallService {
    @Autowired
    private HallRepo hallRepo;

//    Save hall
    public Hall saveHall(Hall hall) {
        return hallRepo.save(hall);
    }

//    Find all Halls
    public List<Hall> findAllHalls() {
        return hallRepo.findAll();
    }

//    Find all Halls order by name desc
    public List<Hall> findAllHallOrderByNameDesc() {
        return hallRepo.findAllByOrderByHallNameDesc();
    }

//    Find a Hall by id
    public Hall findHallById(Long hallId) {
        return hallRepo.findById(hallId).orElseGet(()-> null);
    }

    public void deleteHallById(Long hallId) {
        hallRepo.deleteById(hallId);
    }
}
