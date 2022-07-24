package com.example.cockroachPoc.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "department")
@Getter
@Setter
@NoArgsConstructor
public class Department implements Serializable {

    private static final long serialVersionUID = 7826178536624556624L;

    @Id
    @Column(name = "department_key", length = 128)
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy = "uuid2")
    private String departmentKey;

    @Column(name = "department_type")
    private String departmentType;

    @Column(name = "department_name",length = 1024)
    private String departmentName;

    @Column(name = "description",length = 2048)
    private String description;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Employee> employees = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_key")
    private Company company;

}
