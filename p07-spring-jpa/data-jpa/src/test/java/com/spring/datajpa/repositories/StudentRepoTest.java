package com.spring.datajpa.repositories;

import com.spring.datajpa.entity.Guardian;
import com.spring.datajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepoTest {

    @Autowired
    private StudentRepo studentRepo;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("zukkii@email.com")
                .firstName("Zukkii")
                .lastName("Hampton")
//                .guardianName("Titann")
//                .guardianEmail("titann@email.com")
//                .guardianMobile("703-000-0001")
                .build();

        studentRepo.save(student);
    }

    @Test
    public void saveStudentWithGuarian() {
        Guardian guardian = Guardian.builder()
                .name("Titann")
                .email("titann@email.com")
                .mobile("703-000-0001")
                .build();

        Student student = Student.builder()
                .firstName("Zukk")
                .emailId("zukk@email.com")
                .lastName("Hampton")
                .guardian(guardian)
                .build();

        studentRepo.save(student);
    }

    @Test
    public void printAllStudents() {
        List<Student> studentList = studentRepo.findAll();

        for (Student element : studentList) {
            System.out.println("Student : " + element);
        }
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> studentList = studentRepo.findByFirstName("Zukk");

        for (Student element : studentList) {
            System.out.println("Student : " + element);
        }
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> studentList = studentRepo.findByFirstNameContaining("Zu");

        for (Student element : studentList) {
            System.out.println("Student : " + element);
        }
    }

    @Test
    public void printStudentBaseOnGuardianName() {
        List<Student> studentList = studentRepo.findByGuardianName("Titann");

        int count = 0;
        for (Student element : studentList) {
            count++;
            System.out.println(count + " - " + element);
        }
    }

    @Test
    public void printGetStudentByEmailAddress() {
        Student student = studentRepo.getStudentByEmailAddress("zukk@email.com");

        System.out.println("Student : " + student);
    }

    @Test
    public void printGetStudentFirstNameByEmailAddress() {
        String firstName = studentRepo.getStudentFirstNameByEmailAddress("zukk@email.com");

        System.out.println("First name : " + firstName);
    }

    @Test
    public void printGetStudentByEmailAddressNative() {
        Student student  = studentRepo.getStudentByEmailAddressNative("zukk@email.com");

        System.out.println("Student with specific email : " + student);
    }

    @Test
    public void printGetStudentByEmailAddressNativeNamedParam() {
        Student student  = studentRepo.getStudentByEmailAddressNativeNamedParam("zukk@email.com");

        System.out.println("Student with specific email (Use Param) : " + student);
    }

    @Test
    public void updateStudentNameByEmailId() {
        studentRepo.updateStudentNameByEmailId("ZukkZukk", "zukk@email.com");

        List<Student> studentList = studentRepo.findAll();
        for (Student student : studentList) {
            System.out.println("Student List : " + student);
        }
    }
}