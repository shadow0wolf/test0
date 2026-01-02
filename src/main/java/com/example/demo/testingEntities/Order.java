package com.example.demo.testingEntities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer orderNumber ;
    Date orderDate ;
    Date requiredDate;
    Date shippedDate ;
    String status ;
    String comments;
    @ManyToOne
    @JoinColumn(name = "customerNumber")
    Customer customer;
}
