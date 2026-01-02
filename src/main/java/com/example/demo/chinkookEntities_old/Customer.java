package com.example.demo.chinkookEntities_old;

import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer CustomerId;
    String FirstName;
    String LastName;
    String Company;
    String Address;
    String City;
    String State;
    String Country;
    String PostalCode;
    String Phone;
    String Fax;
    String Email;
    @ManyToOne
    @JoinColumn(name = "SupportRepId")
    Employee SupportRep;
}
