package com.example.cockroachPoc.dto;

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
public class CompanyResponse {

    private String companyKey;

    private Long version;

    private String companyType;

    private String companyName;

    private String description;

    private List<DepartmentResponse> departments;

}
