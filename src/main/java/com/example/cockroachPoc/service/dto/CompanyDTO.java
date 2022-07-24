package com.example.cockroachPoc.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CompanyDTO {

    private String companyKey;

    private Long version;

    private String companyType;

    private String companyName;

    private String description;

    private List<DepartmentDTO> departments;

}
