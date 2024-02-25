package com.studentapi.restful.service;

import com.studentapi.restful.model.Student;

import java.util.List;

public interface StudentService {

     String createStudent(Student student);
     String updateStudent(Student student);
     String deleteStudent(String stuId);
     Student getDetails(String stuId);
     List<Student> getAllDetails();

}
