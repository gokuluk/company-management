package com.example.cockroachPoc.repository;

import com.example.cockroachPoc.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {

    @Override
    Optional<Company> findById(String uuid);

}
