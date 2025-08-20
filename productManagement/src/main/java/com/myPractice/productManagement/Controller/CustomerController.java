package com.myPractice.productManagement.Controller;

import com.myPractice.productManagement.Entity.Customer;
import com.myPractice.productManagement.Service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/customers")
public class CustomerController {
    @Autowired
    private ServiceInterface customerService;
    @GetMapping
    public List<Customer> showCustomers(){
        return customerService.showAllCustomers();
    }
    @PostMapping
    public Customer createACustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }
    @PutMapping
    public Customer updateACustomer(@RequestBody Customer customer){
        return customerService.updateAnyCustomer(customer);
    }
    @DeleteMapping("/{customer_id}")
    public String deleteACustomer(@PathVariable Integer customer_id){
        return customerService.deleteCustomerById(customer_id);
    }
}