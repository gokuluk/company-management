package com.example.cockroachPoc.mapper;

import com.example.cockroachPoc.dto.CompanyResponse;
import com.example.cockroachPoc.entity.Company;
import com.example.cockroachPoc.service.dto.CompanyDTO;
import com.example.CockroachPoc.dto.CompanyRequest;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {})
public interface CompanyMapper {


    CompanyDTO requestDtoToServiceDto(CompanyRequest questionnaireRequest);

    CompanyResponse serviceDtoToResponseDto(CompanyDTO companyDTO);


    @AfterMapping
    default void ensureMappings(@MappingTarget Company company) {
        MapperUtils.setCompanyInDepartments(company);
    }

    CompanyDTO entityToServiceDto(Company company);

    CompanyDTO requestDtoToEntity(CompanyRequest companyRequest);

    Company serviceDtoToEntity(CompanyDTO companyDTO);
}
