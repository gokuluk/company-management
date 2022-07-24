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
public class DepartmentDTO {

    private String departmentKey;

    private String departmentType;

    private String departmentName;

    private String description;

    private List<EmployeeDTO> employees;

}
