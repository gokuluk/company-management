package com.example.cockroachPoc.service;

import com.example.cockroachPoc.dto.CompanyResponse;
import com.example.cockroachPoc.entity.Company;
import com.example.cockroachPoc.mapper.CompanyMapper;
import com.example.cockroachPoc.repository.CompanyRepository;
import com.example.cockroachPoc.service.dto.CompanyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private CompanyRepository companyRepository;

    public CompanyDTO createSurvey(CompanyDTO companyDTO) {

        Company company = companyMapper.serviceDtoToEntity(companyDTO);
        Company savedCompany = companyRepository.save(company);
        CompanyDTO companyResponse = companyMapper.entityToServiceDto(savedCompany);
        return companyResponse;
    }

    public CompanyDTO getSurvey(String companyId) {

        Company company = companyRepository.findById(companyId).orElse(null);
        CompanyDTO companyResponse = companyMapper.entityToServiceDto(company);
        return companyResponse;
    }

}
