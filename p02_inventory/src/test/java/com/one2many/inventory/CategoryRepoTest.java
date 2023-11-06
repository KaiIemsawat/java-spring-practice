package com.one2many.inventory;

import com.one2many.inventory.entities.Category;
import com.one2many.inventory.repositories.CategoryRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class CategoryRepoTest {

    @Autowired
    private CategoryRepo catRepo;

    @Test
    public void testCreateCategory() {
        Category savedCategory = catRepo.save(new Category("Electronics"));

        Assertions.assertTrue(savedCategory.getId() > 0);
    }
}
