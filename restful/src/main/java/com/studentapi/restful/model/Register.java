package com.studentapi.restful.model;

import jakarta.persistence.*;

@Entity
@Table
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int stuId;
    private String email;
    private String password;


    public Register() {
    }

    public Register(int stuId, String email, String password) {
        this.stuId = stuId;
        this.email = email;
        this.password = password;
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
