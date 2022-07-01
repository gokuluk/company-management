package com.example.CockroachPoc.repository;

import com.example.CockroachPoc.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    @Override
    Optional<Employee> findById(String uuid);

}
