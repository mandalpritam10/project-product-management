package com.myPractice.productManagement.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "customer_name", columnDefinition = "TEXT", nullable = false)
    private String customerName;

    @Column(name = "customer_address", columnDefinition = "TEXT", nullable = false)
    private String customerAddress;

    @Column(name = "email", columnDefinition = "TEXT")
    private String email;

    @Column(name = "contact_no", length = 15)
    private String contactNo;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public Customer() {
    }

    public Customer(Integer customerId,String customerName, String customerAddress, String email, String contactNo) {
        this.customerId=customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.email = email;
        this.contactNo = contactNo;
    }

}
