package com.studentapi.restful.service;

import com.studentapi.restful.dto.LoginDto;
import com.studentapi.restful.dto.RegisterDto;
import com.studentapi.restful.model.Register;
import com.studentapi.restful.model.Student;
import com.studentapi.restful.payload.response.LoginMessage;

import java.util.List;

public interface RegisterService {


    public String createStudent(RegisterDto registerDto);
    public String updateStudent(RegisterDto registerDto );
    public String deleteStudent(int stuId);
    public Register getDetails(int stuId);
    public List<Register> getAllDetails();

    LoginMessage loginStudent(LoginDto loginDTO);

}
