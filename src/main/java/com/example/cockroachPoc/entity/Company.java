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
@Table(name = "companys")
@Getter
@Setter
@NoArgsConstructor
public class Company implements Serializable {

    private static final long serialVersionUID = 7826178536624556624L;

    @Id
    @Column(name = "company_key", length = 128)
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy = "uuid2")
    private String companyKey;

    @Version
    @Column(name = "version")
    private Long version;

    @Column(name = "company_type")
    private String companyType;

    @Column(name = "company_name",length = 1024)
    private String companyName;

    @Column(name = "description",length = 2048)
    private String description;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Department> departments = new HashSet<>();

    private void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void addDepartment(Department department) {
        departments.add(department);
        department.setCompany(this);
    }

    public void addDepartments(Collection<Department> departments) {
        Optional.ofNullable(departments).orElseGet(Collections::emptyList).forEach(department -> {
            addDepartment(department);
        });
    }

    public void removeDepartment(Department department) {
        departments.remove(department);
        department.setCompany(null);
    }

    public void removeDepartments(Collection<Department> departments) {
        Optional.ofNullable(departments).orElseGet(Collections::emptyList).forEach(department -> {
            removeDepartment(department);
        });
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company)) return false;
        return companyKey != null && companyKey.equals(((Company) o).getCompanyKey());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
