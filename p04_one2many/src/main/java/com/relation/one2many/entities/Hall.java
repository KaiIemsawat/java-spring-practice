package com.relation.one2many.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "hall")
public class Hall {

    /* ---------- ENTITIES ---------- */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Hall name is need")
    @Size(min = 2, max = 126, message = "Hall name must be in 2-126 characters")
    private String hallName;

    @NotNull(message = "This field can not be empty")
    @Min(value = 1, message = "Must be at least 1 floor")
    private Integer floor;

    @NotNull(message = "This option need to be selected")
    private Boolean isResidential;

    @NotNull(message = "This option need to be selected")
    private Boolean hasLectureRoom;

//    ----- Connecting database -----
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id")
    private University university;


    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    /* ---------- GETTERS | SETTERS ---------- */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHall_name() {
        return hallName;
    }

    public void setHall_name(String hall_name) {
        this.hallName = hall_name;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Boolean getIsResidential() {
        return isResidential;
    }

    public void setIsResidential(Boolean residential) {
        isResidential = residential;
    }

    public Boolean getHasLectureRoom() {
        return hasLectureRoom;
    }

    public void setHasLectureRoom(Boolean hasLectureRoom) {
        this.hasLectureRoom = hasLectureRoom;
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

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    /* ---------- CONSTRUCTORS ---------- */
    public Hall() {}
    public Hall(String hallName, Integer floor, Boolean isResidential, Boolean hasLectureRoom, University university) {
        this.hallName = hallName;
        this.floor = floor;
        this.isResidential = isResidential;
        this.hasLectureRoom = hasLectureRoom;
        this.university = university;
    }
}
