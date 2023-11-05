package com.spring.p01_company;

import com.spring.p01_company.Repositories.UserRepo;
import com.spring.p01_company.entities.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTests {
    @Autowired private UserRepo userRepo;

    @Test
    public void testAddNew() {
        User user = new User();
        user.setEmail("zukkii@email.com");
        user.setPassword("aaaaaa");
        user.setFirstname("Zukkii");
        user.setLastname("Hampton");

        User savedUser = userRepo.save(user);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }
}
