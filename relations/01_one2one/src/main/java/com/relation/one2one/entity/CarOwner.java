package com.relation.one2one.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "car_owner")
public class CarOwner {

    /* ----- ENTITIES ----- */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Firstname is needed")
    @Size(min = 2, max = 120, message = "FirstName must be 2-120 characters")
    private String firstName;

    @NotBlank(message = "Lastname is needed")
    @Size(min = 2, max = 120, message = "Lastname must be 2-120 characters")
    private String lastName;

    @Email(message = "Need to be input in email format")
    @NotBlank(message = "Email is needed")
    private String email;

    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createAt;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updateAt;

    @PrePersist
    protected void onCreate() {
        this.createAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updateAt = new Date();
    }

    /* ----- GETTERS | SETTERS ----- */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    /* ----- CONSTRUCTORS ----- */
    public CarOwner() {}

    public CarOwner(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /* ----- TO_STRING ----- */

    @Override
    public String toString() {
        return "CarOwner{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
