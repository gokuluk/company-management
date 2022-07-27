/*
 *
 *  * Copyright (c) 2021 LogMeIn
 *  * All Rights Reserved Worldwide.
 *  *
 *  * THIS PROGRAM IS CONFIDENTIAL AND PROPRIETARY TO LOGMEIN
 *  * AND CONSTITUTES A VALUABLE TRADE SECRET.
 *
 *
 */

package com.example.cockroachPoc.mapper;


import com.example.cockroachPoc.entity.Company;
import com.example.cockroachPoc.entity.Department;
import com.example.cockroachPoc.entity.Employee;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;


/**
 * This class contains helper methods useful in post mapping association handling.
 */
public class MapperUtils {

    public static void setCompanyInDepartments(Company company) {
        Set<Department> departments = company.getDepartments();

        Optional.ofNullable(departments).orElseGet(Collections::emptySet).forEach(department -> {
            department.setCompany(company);
            setDepartmentInEmployees(department);
        });
    }

    public static void setDepartmentInEmployees(Department department) {
        Set<Employee> employees = department.getEmployees();
        Optional.ofNullable(employees).orElseGet(Collections::emptySet).forEach(employee -> employee.setDepartment(department));
    }


}
