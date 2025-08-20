package com.myPractice.productManagement.Service;

import com.myPractice.productManagement.Entity.Customer;
import com.myPractice.productManagement.Entity.Order;
import com.myPractice.productManagement.Entity.Product;
import com.myPractice.productManagement.Entity.Shipping;

import java.util.List;
import java.util.Optional;

public interface ServiceInterface {
     Product saveProduct(Product product);
     List<Product> getAllProducts();
     Product getAnyProductById(Integer id);
     Product updateAnyProduct(Product product);
     String deleteAnyProductById(Integer id);

     Customer createCustomer(Customer customer);
     List<Customer>showAllCustomers();
     Customer updateAnyCustomer(Customer customer);
     String deleteCustomerById(Integer customer_id);

     Order createOrder(Order order);
     List<Order> getAllOrders();
     Order getAnyOrderById(Integer order_id);
     Order updateAnyOrder(Order order);
     String deleteAnyOrderByID(Integer order_id);

     Shipping createShipping(Shipping shipping);
     List<Shipping> showAllTheShippings();
     List<Shipping> showShippingViaCusId(Integer cusId);
     Optional<Shipping> showShippingViaShippingId(Integer shippingId);
     Shipping updateAnyShipping(Integer slNo, Shipping shipping);
}

