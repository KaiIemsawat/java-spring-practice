package com.college.demo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name="universities")
public class University {

    /* ---------- ENTITIES ---------- */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long university_id;

    @NotBlank(message = "University name must not be empty")
    @Size(min = 2, max = 126, message = "University name must be in 2-126 characters")
    private String university_name;

    @NotBlank(message = "City name must not be empty")
    @Size(min = 2, max = 126, message = "City name must be in 2-126 characters")
    private String city;

    @NotNull
    @Min(value = 300, message = "The number of enrollment need to be over 300")
    private Integer enrollment;

    @NotNull(message = "Must specific whether the university offers online class")
    private boolean hasOnline;

    @NotNull(message = "Must specific whether the university offers in person class")
    private boolean hasInPerson;

    @NotNull
    @Min(value = 1200, message = "Input university need to be found after 1200 BC")
    @Max(value = 2020, message = "University must be founded before 2020 BC")
    private Integer yearFounded;

    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    @PrePersist
    protected void onCreated() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

    /* ---------- GETTERS | SETTERS ---------- */
    public Long getUniversity_id() {
        return university_id;
    }

    public void setUniversity_id(Long university_id) {
        this.university_id = university_id;
    }

    public String getUniversity_name() {
        return university_name;
    }

    public void setUniversity_name(String university_name) {
        this.university_name = university_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Integer enrollment) {
        this.enrollment = enrollment;
    }

    public boolean isHasOnline() {
        return hasOnline;
    }

    public void setHasOnline(boolean hasOnline) {
        this.hasOnline = hasOnline;
    }

    public boolean isHasInPerson() {
        return hasInPerson;
    }

    public void setHasInPerson(boolean hasInPerson) {
        this.hasInPerson = hasInPerson;
    }

    public Integer getYearFounded() {
        return yearFounded;
    }

    public void setYearFounded(Integer yearFounded) {
        this.yearFounded = yearFounded;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /* ---------- CONSTRUCTORS ---------- */
    public University() {}

    public University(String university_name, String city, Integer enrollment, boolean hasOnline, boolean hasInPerson, Integer yearFounded, Date createdAt, Date updatedAt) {
        this.university_name = university_name;
        this.city = city;
        this.enrollment = enrollment;
        this.hasOnline = hasOnline;
        this.hasInPerson = hasInPerson;
        this.yearFounded = yearFounded;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
