package com.one2many.inventory.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Prod_id;

    @NotBlank(message = "Product name can't be blank")
    @Size(min=2, max=126, message = "Product name need to be in between 2 and 126 characters")
    @Column(unique = true)
    private String prod_name;

    @NotNull(message = "Price is needed")
    @Min(value = 2)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    /* GETTERS | SETTERS */

    public Integer getProd_id() {
        return Prod_id;
    }
    public void setProd_id(Integer prod_id) {
        Prod_id = prod_id;
    }
    public String getProd_name() {
        return prod_name;
    }
    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    /* CONSTRUCTORS */
    public Product() {}
    public Product(Integer prod_id, String prod_name, Double price, Category category) {
        Prod_id = prod_id;
        this.prod_name = prod_name;
        this.price = price;
        this.category = category;
    }
}
