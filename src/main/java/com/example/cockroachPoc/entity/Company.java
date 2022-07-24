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
