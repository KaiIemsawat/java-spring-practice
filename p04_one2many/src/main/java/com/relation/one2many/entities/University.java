package com.relation.one2many.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="universities")
public class University {

    /* ---------- ENTITIES ---------- */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long universityId;

    @NotBlank(message = "University name must not be empty")
    @Size(min = 2, max = 126, message = "University name must be in 2-126 characters")
    private String universityName;

    @NotBlank(message = "City name must not be empty")
    @Size(min = 2, max = 126, message = "City name must be in 2-126 characters")
    private String city;

    @NotNull(message = "Enrollment must not be empty")
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

//    ----- Connecting database -----
    @OneToMany(mappedBy = "university", fetch = FetchType.LAZY)
//    mappedBy="thisValue", the value need to match with private ThisValue thisValue on another Entity
    private List<Hall> halls;

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

    public Long getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Long universityId) {
        this.universityId = universityId;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
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

    public boolean getHasOnline() {
        return hasOnline;
    }

    public void setHasOnline(boolean hasOnline) {
        this.hasOnline = hasOnline;
    }

    public boolean getHasInPerson() {
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

    public List<Hall> getHalls() {
        return halls;
    }

    public void setHalls(List<Hall> halls) {
        this.halls = halls;
    }

    /* ---------- CONSTRUCTORS ---------- */
    public University() {}
    public University(String universityName, String city, Integer enrollment, boolean hasOnline, boolean hasInPerson, Integer yearFounded, List<Hall> halls) {
        this.universityName = universityName;
        this.city = city;
        this.enrollment = enrollment;
        this.hasOnline = hasOnline;
        this.hasInPerson = hasInPerson;
        this.yearFounded = yearFounded;
        this.halls = halls;
    }
}
