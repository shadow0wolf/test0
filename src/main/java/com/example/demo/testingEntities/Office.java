package com.example.demo.testingEntities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Office {
    @Id
    String officeCode;
    String varchar;
    String phone ;
    String address;
    String state;
    String country;
    String postalCode;
    String territory;
}
