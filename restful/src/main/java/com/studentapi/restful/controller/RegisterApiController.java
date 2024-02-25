package com.studentapi.restful.controller;


import com.studentapi.restful.dto.LoginDto;
import com.studentapi.restful.dto.RegisterDto;
import com.studentapi.restful.model.Register;
import com.studentapi.restful.payload.response.LoginMessage;
import com.studentapi.restful.service.RegisterService;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/register")
public class RegisterApiController {

    @Autowired
    RegisterService registerService;


    @GetMapping("{stuId}")
    public Register get(@PathVariable("stuId") int stuId){

        return registerService.getDetails(stuId);

    }

    @PostMapping
    public String create(@RequestBody RegisterDto registerDto){

        registerService.createStudent(registerDto);
        return "Created Registration Successfully";
    }


    @PutMapping
    public String update(@RequestBody RegisterDto registerDto){
        registerService.updateStudent(registerDto);
        return "Updated Registration successfully";
    }


    @DeleteMapping("{stuId}")
    public String delete(@PathVariable("stuId") int stuId){
        registerService.deleteStudent(stuId);
        return "Deleted Successfully";
    }

    @GetMapping
    public List<Register> getAllDetails(){
        return registerService.getAllDetails();
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginStudent(@RequestBody LoginDto loginDto){

        LoginMessage loginResponse = registerService.loginStudent(loginDto);
        return ResponseEntity.ok(loginResponse);
    }



}
