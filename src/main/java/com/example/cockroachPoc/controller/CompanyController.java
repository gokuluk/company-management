package com.example.cockroachPoc.controller;

import com.example.cockroachPoc.dto.CompanyResponse;
import com.example.cockroachPoc.entity.Company;
import com.example.cockroachPoc.mapper.CompanyMapper;
import com.example.cockroachPoc.service.CompanyService;
import com.example.CockroachPoc.dto.CompanyRequest;
import com.example.cockroachPoc.service.dto.CompanyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private CompanyService companyService;

    @PostMapping(value = "/company")
    public CompanyResponse createSurvey(@RequestBody CompanyRequest createCompanyRequest) {

        CompanyDTO companyDTO = companyMapper.requestDtoToServiceDto(createCompanyRequest);
        CompanyDTO company = companyService.createSurvey(companyDTO);
        return companyMapper.serviceDtoToResponseDto(company);
    }

    @GetMapping(value = "/company/{companyId}")
    public CompanyResponse getSurvey(@PathVariable("companyId") String companyId) {

        CompanyDTO companyDTO = companyService.getSurvey(companyId);
        return companyMapper.serviceDtoToResponseDto(companyDTO);
    }

}
