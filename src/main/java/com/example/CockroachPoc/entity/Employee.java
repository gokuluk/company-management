package com.example.CockroachPoc.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
public class Employee implements Serializable {

    private static final long serialVersionUID = 7826178536624556624L;

    @Id
    @Column(name = "employee_key", length = 128)
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy = "uuid2")
    private String employeeKey;

    @Column(name = "job_title",length = 1024)
    private String jobTitle;

    @Column(name = "description",length = 2048)
    private String description;

//    @ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne
    @JoinColumn(name = "department_key")
    private Department department;
}
