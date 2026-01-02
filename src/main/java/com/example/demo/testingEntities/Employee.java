package com.example.demo.testingEntities;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer employeeNumber ;
    String lastName;
    String firstName;
    String extension;
    String email;
    @ManyToOne
    @JoinColumn(name="officeCode")
    Office office;
    @ManyToOne
    @JoinColumn(name = "reportsTo")
    Employee manager;
    String jobTitle;
}
