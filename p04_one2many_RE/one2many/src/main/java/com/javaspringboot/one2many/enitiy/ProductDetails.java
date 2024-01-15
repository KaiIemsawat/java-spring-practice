package com.javaspringboot.one2many.enitiy;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "product_details")
public class ProductDetails {

    /* Models */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    @NotBlank
    @Size(min = 2, max = 60, message = "Name needs to be 2 to 60 characters")
    private String name;

    @NotBlank
    @Size(min = 2, max = 45, message = "Value needs to be 2 to 450 characters")
    private String value;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
