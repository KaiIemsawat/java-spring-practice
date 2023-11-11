package com.registration.demo.models;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class LoginUser {

    /* ---------- ENTITIES ---------- */
    @NotBlank(message = "Email is required")
    @Email(message = "Please enter valid email")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;


    /* ---------- GETTERS | SETTERS ---------- */
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

    /* ---------- CONSTRUCTORS ---------- */
    public LoginUser() {}
    public LoginUser(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
