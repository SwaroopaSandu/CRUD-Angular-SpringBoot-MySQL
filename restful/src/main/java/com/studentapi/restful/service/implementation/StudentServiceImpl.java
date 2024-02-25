package com.studentapi.restful.service.implementation;

import com.studentapi.restful.model.Student;
import com.studentapi.restful.respository.StudentRepository;
import com.studentapi.restful.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;


    @Override
    public String createStudent(Student student) {
        studentRepository.save(student);
        return "Success";
    }

    @Override
    public String updateStudent(Student student) {
        studentRepository.save(student);
        return "Updated!";
    }

    @Override
    public String deleteStudent(String stuId) {

        studentRepository.deleteById(stuId);
        return "Success";
    }

    @Override
    public Student getDetails(String stuId) {
        Optional<Student> studentOptional = studentRepository.findById(stuId);

        if (studentOptional.isPresent()) {
            return studentOptional.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No record found for student ID: " + stuId);
        }
    }

    @Override
    public List<Student> getAllDetails() {

        return studentRepository.findAll();
    }

}
