package com.example.demo.testingEntities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class OrderDetail {
    @EmbeddedId
    private OrderDetailId id;

    @OneToOne
    @JoinColumn(name = "orderNumber")
    @MapsId("orderNumber")
    Order order;

    @ManyToOne
    @JoinColumn(name = "productCode")
    @MapsId("productCode")
    Product product;
    Integer quantityOrdered ;
    Float priceEach ;
    Integer orderLineNumber ;
}

@Embeddable
class OrderDetailId implements Serializable {

    @Column(name = "orderNumber")
    private Long orderNumber;

    @Column(name = "productCode")
    private String productCode;

    public OrderDetailId() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailId that = (OrderDetailId) o;
        return java.util.Objects.equals(orderNumber, that.orderNumber)
                && java.util.Objects.equals(productCode, that.productCode);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(orderNumber, productCode);
    }

}