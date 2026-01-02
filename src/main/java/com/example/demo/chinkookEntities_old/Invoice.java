package com.example.demo.chinkookEntities_old;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer InvoiceId;
    @ManyToOne
    @JoinColumn(name="CustomerId")
    Customer customer;
    Date InvoiceDate;
    String BillingAddress;
    String BillingCity;
    String BillingState;
    String BillingCountry;
    String BillingPostalCode;
    BigDecimal Total;
}
