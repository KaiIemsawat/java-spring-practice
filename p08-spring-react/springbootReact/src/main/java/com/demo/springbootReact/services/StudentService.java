package com.demo.springbootReact.services;

import com.demo.springbootReact.models.Student;
import com.demo.springbootReact.repositories.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {

    private final StudentRepo studentRepo;

    @Override
    public Student addStudent(Student student) {

        if (studentAlreadyExists(student.getEmail())) {
            throw new StudentAlreadyExistsException(student.getEmail() + " already exists..!");
        }
        return studentRepo.save(student);
    }


    @Override
    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student updateStudent(Student student, Long id) {
        return null;
    }

    @Override
    public Student getStudentById(Long id) {
        return null;
    }

    @Override
    public void deleteStudentById(Long id) {

    }

    private boolean studentAlreadyExists(String email) {
        return studentRepo.findByEmail(email).isPresent();
    }
}
