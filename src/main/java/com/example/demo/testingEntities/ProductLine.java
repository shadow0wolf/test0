package com.example.demo.testingEntities;

import jakarta.persistence.*;



@Entity
public class ProductLine {
    @Id
    String productLine;
    String textDescription;
    String htmlDescription;
    String image;
}







