package com.spring.datajpa.repositories;

import com.spring.datajpa.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepoTest {

    @Autowired
    private CourseRepo cRepo;

    @Test
    public void printCourses() {
        List<Course> courses = cRepo.findAll();

        for (Course course : courses) {
            System.out.println("Course : " + course);
        }
    }
}