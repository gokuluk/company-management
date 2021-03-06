package com.example.cockroachPoc.repository;

import com.example.cockroachPoc.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {

    @Override
    Optional<Department> findById(String uuid);

}
