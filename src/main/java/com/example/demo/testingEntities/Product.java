package com.example.demo.testingEntities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
    @Id
    String productCode;
    String productName;
    @ManyToOne(optional = false)
    @JoinColumn(name = "productLine")
    ProductLine productline;
    String productPrice;
    String productScale ;
    String productVendor ;
    String productDescription;
    Integer quantityInStock;
    Float buyPrice;
    Float MSRP ;
}
