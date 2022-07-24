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
public class DepartmentResponse {

    private String departmentKey;

    private String departmentType;

    private String departmentName;

    private String description;

    private List<EmployeeResponse> employees;

}
