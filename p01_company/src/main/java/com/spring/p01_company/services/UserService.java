package com.spring.p01_company.services;

import com.spring.p01_company.Repositories.UserRepo;
import com.spring.p01_company.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired private UserRepo userRepo;

    public List<User> listAll() {
        return (List<User>) userRepo.findAll();
    }

    public void save(User user) {
        userRepo.save(user);
    }

    public User get(Integer id) throws UserNotFoundException {
        Optional<User> user = userRepo.findById(id);

        if (user.isPresent()) {
            return user.get();
        }
        throw new UserNotFoundException("Could not find user id : " + id);
    }

    public void deleteUserById(Integer id) throws UserNotFoundException {
        Long count = userRepo.countById(id);

        if (count == null || count == 0) {
            throw new UserNotFoundException("Could not find user id : " + id);
        }
        userRepo.deleteById(id);
    }
}
