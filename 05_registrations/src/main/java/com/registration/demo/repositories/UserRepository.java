package com.registration.demo.repositories;

import com.registration.demo.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll(); // Don't really need in this case

    Optional<User> findByEmail(String email); // Find any user that match with given email, if any

}
