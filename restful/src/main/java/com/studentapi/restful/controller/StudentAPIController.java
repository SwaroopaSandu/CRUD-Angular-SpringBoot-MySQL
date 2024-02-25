package com.studentapi.restful.controller;


import com.studentapi.restful.model.Student;
import com.studentapi.restful.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentAPIController {

   StudentService studentService;

    public StudentAPIController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("{stuId}")
    public Student getStudentDetails(@PathVariable("stuId") String stuId){
        return studentService.getDetails(stuId);
   }


    @GetMapping()
    public List<Student> getAllStudentDetails(){
        return studentService.getAllDetails();
    }


    @PostMapping()
    public String insertData(@RequestBody Student student){

        studentService.createStudent(student);
        return "Created";
    }


    @PutMapping()
    public String updateData(@RequestBody Student student){

        studentService.updateStudent(student);
        return "Record updated succesfully";

    }


    @DeleteMapping("{stuId}")
    public String deleteData(@PathVariable("stuId") String stuId){
        studentService.deleteStudent(stuId);
        return "Deleted!";
    }


}
