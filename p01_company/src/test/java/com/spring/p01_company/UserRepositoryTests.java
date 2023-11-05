package com.spring.p01_company;

import com.spring.p01_company.Repositories.UserRepo;
import com.spring.p01_company.entities.User;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTests {

    @Autowired private UserRepo userRepo;

    @Test
    public void testAddNew() {
        User user = new User();
        user.setEmail("titann@email.com");
        user.setPassword("qqqqqq");
        user.setFirstname("Titann");
        user.setLastname("Hampton");

        User savedUser = userRepo.save(user);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll() {
        Iterable<User> users = userRepo.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(1);

        for(User eaUser: users) {
            System.out.println(eaUser);
        }
    }

    @Test
    public void testUpdate() {
        Integer userId = 1;
        Optional<User> optionalUser = userRepo.findById(userId);
        User user = optionalUser.get();
        user.setLastname("Iem");
        userRepo.save(user);

        User updatedUser = userRepo.findById(userId).get();
        Assertions.assertThat(updatedUser.getLastname()).isEqualTo("Iem");
    }

    @Test
    public void testGetUser() {
        Integer userId = 2;
        Optional<User> optionalUser = userRepo.findById(userId);
        Assertions.assertThat(optionalUser).isPresent();
        System.out.println(optionalUser.get());
    }
}
