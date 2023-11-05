package com.spring.p01_company.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "email is mandatory")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "password field need to be filled")
    @Size(min = 5, message = "password need at least 5 characters")
    private String password;

    @NotBlank(message = "firstname is required")
    @Size(min = 2, message = "firstname need at least 2 characters")
    @Size(max = 25, message = "firstname can't be longer than 25 characters")
    @Column(name = "first_name")
    private String firstname;

    @NotBlank(message = "lastname is required")
    @Size(min = 2, message = "lastname need at least 2 characters")
    @Size(max = 50, message = "lastname can't be longer than 50 characters")
    @Column(name = "last_name")
    private String lastname;

    /* SETTERS | GETTERS*/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /* TO STRING */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
