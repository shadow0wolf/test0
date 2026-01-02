package com.example.demo.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class EmployeeEntity {
    @Id
    Integer id;
    String name;
    Integer department_id;
    Integer manager_id;
}
