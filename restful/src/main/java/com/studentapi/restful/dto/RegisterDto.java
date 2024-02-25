package com.studentapi.restful.dto;

public class RegisterDto {
    private int stuId;
    private String email;
    private String password;


    public RegisterDto(int stuId, String email, String password) {
        this.stuId = stuId;
        this.email = email;
        this.password = password;
    }

    public RegisterDto() {
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
