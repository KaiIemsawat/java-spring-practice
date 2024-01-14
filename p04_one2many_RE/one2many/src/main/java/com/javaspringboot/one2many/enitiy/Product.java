package com.javaspringboot.one2many.enitiy;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Product {

    /* Models */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    @NotBlank
    @Size(min = 2, max = 60, message = "Name needs to be 2 to 60 characters")
    private String name;

    @NotNull(message="Need value input")
    @DecimalMin(value="49.99", message="Value must be greater than or equal to 49.99")
    private Float price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    /* Constructors */


    /* Getters | Setters */
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
