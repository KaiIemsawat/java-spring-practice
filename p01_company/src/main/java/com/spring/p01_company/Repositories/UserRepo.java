package com.spring.p01_company.Repositories;

import com.spring.p01_company.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {
    public Long countById(Integer id);
}
