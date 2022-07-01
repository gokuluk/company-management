
CREATE TABLE employee
(
    employee_key   VARCHAR(128) NOT NULL,
    permanent     BOOLEAN,
    description VARCHAR(2048),
    salary       FLOAT,
    sort_order  INTEGER,
    employee_name       VARCHAR(1024),
    job_title       VARCHAR(1024),
    department_key VARCHAR(128),
    PRIMARY KEY (employee_key)
)
;

CREATE TABLE department
(
    department_key     VARCHAR(128) NOT NULL,
    description      VARCHAR(2048),
    is_critical      BOOLEAN,
    max_version      BIGINT,
    department_type    VARCHAR(255),
    read_only        BOOLEAN,
    department_name    VARCHAR(1024),
    sort_order  INTEGER,
    company_key VARCHAR(128),
    PRIMARY KEY (department_key)
)
;

CREATE TABLE company
(
    company_key      VARCHAR(128) NOT NULL,
    created_by            VARCHAR(255),
    created_time          BIGINT,
    updated_by            VARCHAR(255),
    updated_time          BIGINT,
    description           VARCHAR(2048),
    is_public             BOOLEAN,
    company_type    VARCHAR(255),
    company_version BIGINT,
    company_name          VARCHAR(1024),
    version               BIGINT,
    PRIMARY KEY (company_key)
)
;

ALTER TABLE employee
    ADD CONSTRAINT xfk_departmentkey_employee FOREIGN KEY (department_key) REFERENCES
        department(department_key)
;

ALTER TABLE department
    ADD CONSTRAINT xfk_companykey_department FOREIGN KEY (department_key)
        REFERENCES company(company_key)
;