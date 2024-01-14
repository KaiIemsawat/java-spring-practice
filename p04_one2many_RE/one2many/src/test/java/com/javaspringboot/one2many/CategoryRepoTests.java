package com.javaspringboot.one2many;

import com.javaspringboot.one2many.enitiy.Category;
import com.javaspringboot.one2many.repositories.CategoryRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(value = false)
public class CategoryRepoTests {

    @Autowired
    private CategoryRepo categoryRepo;

    @Test
    public void testCreateCategory() {
        Category savedCategory = categoryRepo.save(new Category("Electronics"));

        assertThat(savedCategory.getId()).isGreaterThan(0);
    }
}
