package com.studentapi.restful.respository;

import com.studentapi.restful.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@EnableJpaRepositories
@Repository
public interface RegisterRepository extends JpaRepository<Register,Integer> {

    Optional<Register> findOneByEmailAndPassword(String email, String password);
    Register findByEmail(String email);



}
