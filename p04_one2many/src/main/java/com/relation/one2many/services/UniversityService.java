package com.relation.one2many.services;

import com.relation.one2many.entities.University;
import com.relation.one2many.repositories.UniversityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniversityService {

    @Autowired private UniversityRepo universityRepo;
//    The line above equals to ------------------------
//    private final UniversityRepo universityRepo;
//    public UniversityService(UniversityRepo universityRepo) {
//        this.universityRepo = universityRepo;
//    }
//    -------------------------------------------------

    //    Add University
    public University createUniversity(University university) {
        return universityRepo.save(university);
    }

    //    Find all universities
    public List<University> findAllUniversities() {
        return universityRepo.findAll();
    }

    //    Find one university
    public University findUniversityById(Long id) {
//        Optional<University> optionalUniversity = universityRepo.findById(id);
//        return optionalUniversity.orElseGet(()-> null);
        return universityRepo.findById(id).orElseGet(()-> null);
    }

    //    Update a university
    public University saveUniversity(University updatedUniversity) {
        return universityRepo.save(updatedUniversity);
    }

    //    Delete a university
    public void deleteUniversity(Long id) {
        universityRepo.deleteById(id);
    }
}
