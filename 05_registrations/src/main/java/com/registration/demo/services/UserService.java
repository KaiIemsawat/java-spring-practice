package com.registration.demo.services;

import com.registration.demo.models.User;
import com.registration.demo.repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Optional;

@Service
public class UserService {

    @Autowired private UserRepository userRepo;

//    REGISTER USER
    public User register(User newUser, BindingResult result) {
//        Check if passwords agree
        if(!newUser.getConfirmPassword().equals(newUser.getPassword())) { // If not agree
            result.rejectValue("confirmPassword", "Matches", "Your password must agree!!");
        }
//        Check if email is already used
        Optional<User> optionalUser = userRepo.findByEmail(newUser.getEmail());
        if(optionalUser.isPresent()) {
            result.rejectValue("email", "Matches", "This email is already registered!!");
        }
        if(result.hasErrors()) {
            return null;
        }
        else {
//            Hash the password and save to database
            String hashedPassword = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
            newUser.setPassword(hashedPassword);
            return userRepo.save(newUser);
        }
    }

//    Find User by id
    public User findUserById(Long id) {
        return userRepo.findById(id).orElseGet(()-> null);
    }

//    Find User by email
    public User findUserByEmail(String email) {
        return userRepo.findByEmail(email).orElseGet(()-> null);
    }

//    Save User
    public User saveUser(User user) {
        return userRepo.save(user);
    }

//    Delete User
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
}
