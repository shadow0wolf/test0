package com.example.demo.chinookEntities;

import jakarta.persistence.*;

@Entity
@Table(name = "media_type")
public class MediaType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "media_type_id")
    private Integer mediaTypeId;

    @Column(name = "name")
    private String name;
}