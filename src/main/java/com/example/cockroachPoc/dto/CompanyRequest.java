package com.example.CockroachPoc.dto;

import com.example.cockroachPoc.dto.DepartmentRequest;
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
public class CompanyRequest {

    private String companyKey;

    private Long version;

    private String companyType;

    private String companyName;

    private String description;

    private List<DepartmentRequest> departments;

}
