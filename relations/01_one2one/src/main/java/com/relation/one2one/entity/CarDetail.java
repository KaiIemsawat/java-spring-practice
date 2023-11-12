package com.relation.one2one.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "car_detail")
public class CarDetail {

    /* ----- ENTITIES ----- */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int carId;

    @NotBlank(message = "This field need to be filled")
    private String Build;

    @NotBlank(message = "This field need to be filled")
    private String Model;

    @NotBlank(message = "This field need to be filled")
    private int year;

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

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getBuild() {
        return Build;
    }

    public void setBuild(String build) {
        Build = build;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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
    public CarDetail(){}
    public CarDetail(String build, String model, int year, Date createAt, Date updateAt) {
        Build = build;
        Model = model;
        this.year = year;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    /* ----- TO STRING ----- */
    @Override
    public String toString() {
        return "CarDetail{" +
                "carId=" + carId +
                ", Build='" + Build + '\'' +
                ", Model='" + Model + '\'' +
                ", year=" + year +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}
