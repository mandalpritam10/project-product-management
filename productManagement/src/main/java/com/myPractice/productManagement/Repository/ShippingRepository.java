package com.myPractice.productManagement.Repository;

import com.myPractice.productManagement.Entity.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShippingRepository extends JpaRepository<Shipping,Integer> {
    List<Shipping> findByCusId(Integer cusId);
    Optional<Shipping> findByShippingId(Integer shippingId);
    List<Shipping> findAllByOrderBySlNoAsc();
}