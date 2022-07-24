package com.example.cockroachPoc.mapper;

import com.example.cockroachPoc.dto.CompanyResponse;
import com.example.cockroachPoc.entity.Company;
import com.example.cockroachPoc.service.dto.CompanyDTO;
import com.example.CockroachPoc.dto.CompanyRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface CompanyMapper {


    CompanyDTO requestDtoToServiceDto(CompanyRequest questionnaireRequest);

    CompanyResponse serviceDtoToResponseDto(CompanyDTO companyDTO);


    CompanyDTO entityToServiceDto(Company company);

    CompanyDTO requestDtoToEntity(CompanyRequest companyRequest);

    Company serviceDtoToEntity(CompanyDTO companyDTO);
}
