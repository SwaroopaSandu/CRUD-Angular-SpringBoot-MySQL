package com.studentapi.restful.service.implementation;

import com.studentapi.restful.dto.LoginDto;
import com.studentapi.restful.dto.RegisterDto;
import com.studentapi.restful.model.Register;
import com.studentapi.restful.model.Student;
import com.studentapi.restful.payload.response.LoginMessage;
import com.studentapi.restful.respository.RegisterRepository;
import com.studentapi.restful.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    RegisterRepository registerRepository;



    public String createStudent(RegisterDto registerDto){

        Register register = new Register(registerDto.getStuId(),
                registerDto.getEmail(),registerDto.getPassword());

        registerRepository.save(register);
        return "Created Registration!";

    }


    public String updateStudent(RegisterDto registerDto){

        Register register = new Register(registerDto.getStuId(),
                registerDto.getEmail(),registerDto.getPassword());

        registerRepository.save(register);
        return "Updated Registration!";
    }


    public String deleteStudent(int stuId){

        registerRepository.deleteById(stuId);
        return "Deleted Registration";
    }

    public Register getDetails(int stuId){

        return registerRepository.findById(stuId).get();
    }

    public List<Register> getAllDetails()
    {

        return registerRepository.findAll();
    }

    public LoginMessage loginStudent(LoginDto loginDto) {
        Register registerStudent = registerRepository.findByEmail(loginDto.getEmail());
        if (registerStudent != null) {
                String password = loginDto.getPassword();
                Optional<Register> student = registerRepository.findOneByEmailAndPassword(loginDto.getEmail(), password);
                if (student.isPresent()) {
                    return new LoginMessage("Login Success", true);
                } else {
                    return new LoginMessage("Login Failed", false);
                }

        }
        else {
            return new LoginMessage("Email not exits", false);
        }
    }


}
