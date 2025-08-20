package com.myPractice.productManagement.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "shipping")
public class Shipping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sl_no")
    private Integer slNo;

    @Column(name = "shipping_id")
    private Integer shippingId;
    @Column(name = "cus_id")
    private Integer cusId;
    @Column(name = "cus_name", columnDefinition = "TEXT")
    private String cusName;
    @Column(name = "shipping_address", columnDefinition = "TEXT")
    private String shippingAddress;

    private Integer quantity;
    @Column(name = "order_price")
    private Double orderPrice;
    @Column(name = "shipping_date_time")
    private LocalDateTime shippingDateTime;

    public Integer getSlNo() {
        return slNo;
    }

    public void setSlNo(Integer slNo) {
        this.slNo = slNo;
    }

    public Integer getShippingId() {
        return shippingId;
    }

    public void setShippingId(Integer shippingId) {
        this.shippingId = shippingId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public LocalDateTime getShippingDateTime() {
        return shippingDateTime;
    }

    public void setShippingDateTime(LocalDateTime shippingDateTime) {
        this.shippingDateTime = shippingDateTime;
    }

    public Shipping() {
    }

    public Shipping(Integer slNo, Integer shippingId, Integer cusId, String shippingAddress, String cusName, Integer quantity, Double orderPrice, LocalDateTime shippingDateTime) {
        this.slNo = slNo;
        this.shippingId = shippingId;
        this.cusId = cusId;
        this.shippingAddress = shippingAddress;
        this.cusName = cusName;
        this.quantity = quantity;
        this.orderPrice = orderPrice;
        this.shippingDateTime = shippingDateTime;
    }
}