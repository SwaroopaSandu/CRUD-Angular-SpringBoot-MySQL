package com.studentapi.restful.respository;

import com.studentapi.restful.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,String> {

}
