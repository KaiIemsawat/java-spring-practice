package com.demo.springbootReact.services;

import com.demo.springbootReact.models.Student;

import java.util.List;

public interface IStudentService {
    Student addStudent(Student student);

    List<Student> getStudents();

    Student updateStudent(Student student, Long id);

    Student getStudentById(Long id);

    void deleteStudentById(Long id);
}
