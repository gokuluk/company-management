package com.example.cockroachPoc.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "departments")
@Getter
@Setter
@NoArgsConstructor
public class Department implements Serializable {

    private static final long serialVersionUID = 7826178536624556629L;

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

    private void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        employee.setDepartment(this);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
        employee.setDepartment(null);
    }

    public void addEmployees(Collection<Employee> employees) {
        Optional.ofNullable(employees).orElseGet(Collections::emptyList).forEach(employee -> {
            addEmployee(employee);
        });
    }

    public void removeEmployees(Collection<Employee> employees) {
        Optional.ofNullable(employees).orElseGet(Collections::emptyList).forEach(employee -> {
            removeEmployee(employee);
        });
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        return departmentKey != null && departmentKey.equals(((Department) o).getDepartmentKey());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
