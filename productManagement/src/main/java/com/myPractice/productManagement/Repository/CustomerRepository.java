package com.myPractice.productManagement.Repository;

import com.myPractice.productManagement.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    List<Customer> findAllByOrderByCustomerIdAsc();
}