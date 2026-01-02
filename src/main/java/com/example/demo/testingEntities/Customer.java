package com.example.demo.testingEntities;

import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer customerNumber;
    String customerName ;
    String contactLastName ;
    String contactFirstName ;
    String phone ;
    String address;
    String city ;
    String state ;
    String postalCode ;
    String country ;
    @ManyToOne
    @JoinColumn(name="salesRepEmployeeNumber")
    Employee salesRepEmployee;
    Float creditLimit;
}