package com.demo.springbootreact.service;

import com.demo.springbootreact.exception.StudentAlreadyExistsException;
import com.demo.springbootreact.exception.StudentNotFoundException;
import com.demo.springbootreact.model.Student;
import com.demo.springbootreact.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {

    private final StudentRepo studentRepo;

    @Override
    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student addStudent(Student student) {
        if (studentAlreadyExists(student.getEmail())) {
            throw new StudentAlreadyExistsException(student.getEmail() + " already exists!");
        }
        return studentRepo.save(student);
    }

    @Override
    public Student updateStudent(Student student, Long id) {
        return studentRepo.findById(id).map(st -> {
            st.setFirstName(student.getFirstName());
            st.setLastName(student.getLastName());
            st.setEmail(student.getEmail());
            st.setDepartment(student.getDepartment());
            return studentRepo.save(st);
        }).orElseThrow(() -> new StudentNotFoundException("Student with #" + id + " is not found"));
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepo.findById(id).orElseThrow(
                ()-> new StudentNotFoundException("Student with #" + id + " is not found")
        );
    }

    @Override
    public void deleteStudent(Long id) {
        if (!studentRepo.existsById(id)) {
            throw new StudentNotFoundException("Student with #" + id + " is not found");
        }
    }


    private boolean studentAlreadyExists(String email) {
        return studentRepo.findByEmail(email).isPresent();
    }
}
