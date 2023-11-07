package com.one2many.inventory.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min = 2, max = 126, message = "Brand name need to be in between 2 and 126 characters")
    private String name;

    @OneToMany(mappedBy = "brand")
    private List<Category> categories = new ArrayList<>();

    /* GETTERS | SETTERS */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    /* CONSTRUCTORS */
    public Brand(){}
    public Brand(Integer id, String name, List<Category> categories) {
        this.id = id;
        this.name = name;
        this.categories = categories;
    }
}
