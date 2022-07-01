package com.example.CockroachPoc.controller;

import com.example.CockroachPoc.entity.Company;
import com.example.CockroachPoc.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @PostMapping(value = "/company")
    public Company createSurvey(@RequestBody Company createQuestionnaireRequest) {

        Company company = companyRepository.save(createQuestionnaireRequest);
        return company;
    }

    @GetMapping(value = "/company/{companyId}")
    public Company getSurvey(@PathVariable("companyId") String companyId) {

        Company company = companyRepository.findById(companyId).orElse(null);
        return company;
    }

}
