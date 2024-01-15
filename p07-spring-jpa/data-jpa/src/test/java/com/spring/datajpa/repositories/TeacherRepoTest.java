package com.spring.datajpa.repositories;

import com.spring.datajpa.entity.Course;
import com.spring.datajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepoTest {

    @Autowired
    private TeacherRepo teacherRepo;

    @Test
    public void saveTeacher() {
        Course courseDBA = Course.builder()
                .title("DBA")
                .credit(5)
                .build();

        Course courseJava = Course.builder()
                .title("DBA")
                .credit(8)
                .build();

        Course courseSpring = Course.builder()
                .title("DBA")
                .credit(6)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("TeacherFirstName")
                .lastName("TeacherLastName")
//                .courses(List.of(courseDBA, courseJava, courseSpring))
                .build();

        teacherRepo.save(teacher);
    }
}