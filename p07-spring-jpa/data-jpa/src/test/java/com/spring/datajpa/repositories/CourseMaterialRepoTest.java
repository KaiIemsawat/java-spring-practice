package com.spring.datajpa.repositories;

import com.spring.datajpa.entity.Course;
import com.spring.datajpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepoTest {

    @Autowired
    private CourseMaterialRepo course_m_repo;

    @Test
    public void saveCourseMaterial() {
        Course course = Course.builder()
                .title("Backend")
                .credit(6)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.test-url-3.com")
                .course(course)
                .build();

        course_m_repo.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials() {
        List<CourseMaterial> courseMaterials = course_m_repo.findAll();

        for(CourseMaterial courseMaterial : courseMaterials) {
            System.out.println( "Course Material : " + courseMaterial);
        }
    }

}