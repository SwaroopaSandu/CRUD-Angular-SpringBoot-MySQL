package com.studentapi.restful.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table()
public class Student {

    @Id
    private String stuId;
    private String name;
    private String address;
    private String contact;

    public Student() {
    }

    public Student(String stuId, String name, String address, String contact) {
        this.stuId = stuId;
        this.name = name;
        this.address = address;
        this.contact = contact;
    }


    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
