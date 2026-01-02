package com.example.demo.chinkookEntities_old;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class InvoiceLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer InvoiceLineId;
    @ManyToOne
    @JoinColumn(name = "InvoiceId")
    Invoice invoice;
    @ManyToOne
    @JoinColumn(name = "TrackId")
    Track track;
    BigDecimal UnitPrice;
    Integer Quantity;
}
