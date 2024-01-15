package com.spring.datajpa.repositories;

import com.spring.datajpa.entity.Course;
import com.spring.datajpa.entity.Student;
import com.spring.datajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("SuperZuk")
                .lastName("Ham")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(4)
                .teacher(teacher)
                .build();

        cRepo.save(course);
    }

    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);

        Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);

        List<Course> courses = cRepo.findAll(secondPageWithTwoRecords).getContent();

        long totalElements = cRepo.findAll(secondPageWithTwoRecords).getTotalElements();

        long totalPages = cRepo.findAll(secondPageWithTwoRecords).getTotalPages();

        System.out.println("Total pages : " + totalPages);
        System.out.println("Total elements : " + totalElements);
        System.out.println("Course : " + courses);
    }

    @Test
    public void findAllSorting() {
        Pageable sortByTitle = PageRequest
                .of(0,2, Sort.by("title"));

        Pageable sortByCreditDesc  = PageRequest.
                of(0, 2, Sort.by("credit")
                        .descending());

        Pageable sortByTitleAndCreditDesc = PageRequest
                .of(0, 2, Sort.by("title")
                        .descending()
                        .and(Sort.by("credit"))
                );

        List<Course> courses = cRepo.findAll(sortByTitle).getContent();

        System.out.println("courses = " + courses);
    }

    @Test
    public void printFindByTitleContaining() {
        Pageable firstPageTenRecords = PageRequest.of(0, 10);

        List<Course> courses = cRepo.findByTitleContaining("D", firstPageTenRecords).getContent();

        int count = 0;
        for (Course course : courses) {
            count++;
            System.out.println(count + " : " + course);
        }
    }

    @Test
    public void saveCourseWithStudentAndTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("This Teacher")
                .lastName("This Teacher LastName")
                .build();

        Student student = Student.builder()
                .firstName("StudentName")
                .lastName("StudentLastName")
                .emailId("thisstudent@email.com")
                .build();

        Course course = Course.builder()
                .title("This Course Title")
                .credit(2)
                .teacher(teacher)
                .build();

        course.addStudent(student);

        cRepo.save(course);
    }
}