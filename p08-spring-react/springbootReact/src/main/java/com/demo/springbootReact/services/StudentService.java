package com.demo.springbootReact.services;

import com.demo.springbootReact.exceptions.StudentAlreadyExistsException;
import com.demo.springbootReact.exceptions.StudentNotFoundException;
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
        return studentRepo.findById(id).map(st -> {
            st.setFirstName(student.getFirstName());
            st.setLastName(student.getLastName());
            st.setEmail(student.getEmail());
            st.setDepartment(student.getDepartment());

            return studentRepo.save(st);
        }).orElseThrow(
                () -> new StudentNotFoundException("Sorry, this student could not be found")
        );
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepo.findById(id).orElseThrow(
                () -> new StudentNotFoundException("Sorry, No student found with id : " + id)
        );
    }

    @Override
    public void deleteStudentById(Long id) {
        if (!studentRepo.existsById(id)) {
            throw new StudentNotFoundException("Sorry, No student found with id : " + id);
        }
        studentRepo.deleteById(id);
    }

    private boolean studentAlreadyExists(String email) {
        return studentRepo.findByEmail(email).isPresent();
    }
}
