package com.example.demo.testingEntities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
class Payment {
    @EmbeddedId
    PaymentId paymentId;
    @ManyToOne
    @JoinColumn(name = "customerNumber")
    @MapsId("customerNumber")
    Customer customer;
    Date paymentDate;
    Float amount ;
}


@Embeddable
class PaymentId implements Serializable {
    @Column(name = "customerNumber")
    Integer customerNumber;
    @Column(name = "checkNumber")
    String checkNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentId that = (PaymentId) o;
        return java.util.Objects.equals(customerNumber, that.customerNumber)
                && java.util.Objects.equals(checkNumber, that.checkNumber);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(customerNumber, checkNumber);
    }
}
