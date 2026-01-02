package com.example.demo.chinkookEntities_old;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer EmployeeId;
    String LastName;
    String FirstName;
    String Title;
    @ManyToOne
    @JoinColumn(name="ReportsTo")
    Employee manager ;
    Date BirthDate;
    Date HireDate ;
    String Address;
    String City;
    String State;
    String Country;
    String PostalCode;
    String Phone;
    String Fax;
    String Email;
}
