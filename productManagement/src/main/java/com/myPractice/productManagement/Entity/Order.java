package com.myPractice.productManagement.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "product_id")
    private Integer productId;

    private Integer quantity;

    @Column(name = "order_price")
    private Double orderPrice;

    @Column(name = "order_date_time")
    private LocalDateTime orderDateTime;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(LocalDateTime orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public Order() {
    }

    public Order(Integer orderId, Integer productId, Integer quantity, Double orderPrice, LocalDateTime orderDateTime) {
            this.orderId = orderId;
            this.productId = productId;
            this.quantity = quantity;
            this.orderPrice = orderPrice;
            this.orderDateTime = orderDateTime;
        }
}