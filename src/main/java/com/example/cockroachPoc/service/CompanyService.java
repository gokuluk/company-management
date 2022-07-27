package com.example.cockroachPoc.service;

import com.example.cockroachPoc.entity.Company;
import com.example.cockroachPoc.mapper.CompanyMapper;
import com.example.cockroachPoc.repository.CompanyRepository;
import com.example.cockroachPoc.service.dto.CompanyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private CompanyRepository companyRepository;

    @Transactional
    public CompanyDTO createSurvey(CompanyDTO companyDTO) {

        Company company = companyMapper.serviceDtoToEntity(companyDTO);
        Company savedCompany = companyRepository.save(company);
        return companyMapper.entityToServiceDto(savedCompany);
    }

    public CompanyDTO getSurvey(String companyId) {

        Optional<Company> company = companyRepository.getByCompanyKey(companyId);
        return companyMapper.entityToServiceDto(company.get());
    }


    public void deleteSurvey(String companyId) {

        companyRepository.deleteById(companyId);
    }

}
