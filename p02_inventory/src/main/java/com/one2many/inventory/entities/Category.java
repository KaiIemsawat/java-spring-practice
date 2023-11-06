package com.one2many.inventory.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "category") // optional. By default, the table will be named as the class name
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name can't be blank")
    @Size(min=2, max=126, message = "Name need to be in between 2 and 126 characters")
    @Column(unique = true)
    private String name;

    /* GETTERS | SETTERS*/
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

    /* CONSTRUCTOR */
    public Category() {}
    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public Category(String name) {
        this.name = name;
    }
    public Category(Integer id) {
        this.id = id;
    }

    /* TO STRING */
    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
