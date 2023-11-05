package com.spring.p01_company.services;

import com.spring.p01_company.Repositories.UserRepo;
import com.spring.p01_company.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired private UserRepo userRepo;

    public List<User> listAll() {
        return (List<User>) userRepo.findAll();
    }
}
