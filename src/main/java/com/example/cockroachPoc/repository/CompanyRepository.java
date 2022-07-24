package com.example.cockroachPoc.repository;

import com.example.cockroachPoc.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {

    @Override
    Optional<Company> findById(String uuid);

    @Query("from Company q left join fetch q.departments qtn left join fetch qtn.employees op where q.companyKey= :companyKey and (op.employeeKey is null or op.employeeKey is not null)")
    Optional<Company> getByCompanyKey(@Param("companyKey") String companyKey);
}
