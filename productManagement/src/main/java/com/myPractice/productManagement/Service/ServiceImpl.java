package com.myPractice.productManagement.Service;

import com.myPractice.productManagement.Entity.Customer;
import com.myPractice.productManagement.Entity.Order;
import com.myPractice.productManagement.Entity.Product;
import com.myPractice.productManagement.Entity.Shipping;
import com.myPractice.productManagement.Repository.CustomerRepository;
import com.myPractice.productManagement.Repository.OrderRepository;
import com.myPractice.productManagement.Repository.ProductRepository;
import com.myPractice.productManagement.Repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceImpl implements ServiceInterface{
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ShippingRepository shippingRepository;
//product
    @Override
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }
    @Override
    public List<Product> getAllProducts(){
        return productRepository.findAllByOrderByIdAsc();
    }
    @Override
    public Product getAnyProductById(Integer id){
        return productRepository.findById(id).orElse(null);
    }
    @Override
    public Product updateAnyProduct(Product product){
        return productRepository.save(product);
    }
    @Override
    public String deleteAnyProductById(Integer id){
        productRepository.deleteById(id);
        return "the product is deleted with id no:- "+id;
    }
//customer
    @Override
    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }
    @Override
    public List<Customer>showAllCustomers(){
        return customerRepository.findAllByOrderByCustomerIdAsc();
    }
    @Override
    public Customer updateAnyCustomer(Customer customer){
        return customerRepository.save(customer);
    }
    @Override
    public String deleteCustomerById(Integer customer_id) {
        customerRepository.deleteById(customer_id);
        return "the customer is deleted having in no:-"+customer_id;
    }
//order
    @Override
    public Order createOrder(Order order){
        productRepository.findById(order.getProductId())
                .orElseThrow(()->new RuntimeException("Product not found"));
        order.setOrderDateTime(LocalDateTime.now());
        return orderRepository.save(order);
    }
    @Override
    public List<Order> getAllOrders(){
        return orderRepository.findAllByOrderByOrderIdAsc();
    }
    @Override
    public Order getAnyOrderById(Integer order_id){
        return orderRepository.findById(order_id)
                .orElseThrow(()->new RuntimeException("Order not exists"));
    }
    @Override
    public Order updateAnyOrder(Order order){
        Order existingOrder=orderRepository.findById(order.getOrderId())
                .orElseThrow(()->new RuntimeException("Order doesn't exist"));
        if(!existingOrder.getProductId().equals(order.getProductId())){
            productRepository.findById(order.getProductId()).
                    orElseThrow(()->new RuntimeException("Product not found by id:-"+order.getProductId()));
        }
        existingOrder.setQuantity(order.getQuantity());
        existingOrder.setOrderDateTime((order.getOrderDateTime()));
        return orderRepository.save((existingOrder));
    }
    @Override
    public String deleteAnyOrderByID(Integer order_id){
        orderRepository.deleteById(order_id);
        return "Order has been removed with order_id:- "+order_id;
    }
//shipping
    @Override
    public Shipping createShipping(Shipping shipping) {
        Order order = orderRepository.findById(shipping.getShippingId())
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + shipping.getShippingId()));

        Customer customer = customerRepository.findById(shipping.getCusId())
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + shipping.getCusId()));

        List<Shipping> existingShipping = shippingRepository.findAllByOrderBySlNoAsc();
        for (Shipping s : existingShipping) {
            if (s.getShippingId().equals(shipping.getShippingId())) {
                throw new RuntimeException("Shipping already exists for Order ID: " + shipping.getShippingId());
            }
        }

        shipping.setShippingDateTime(LocalDateTime.now());
        return shippingRepository.save(shipping);
    }
    @Override
    public List<Shipping> showAllTheShippings(){
        return shippingRepository.findAllByOrderBySlNoAsc();
    }
    @Override
    public List<Shipping> showShippingViaCusId(Integer cus_id) {
        return shippingRepository.findByCusId(cus_id);
    }
    @Override
    public Optional<Shipping> showShippingViaShippingId(Integer shippingId){
        return shippingRepository.findByShippingId(shippingId);
    }
    @Override
    public Shipping updateAnyShipping(Integer slNo, Shipping shipping){
        Shipping existingShipping=shippingRepository.findById(slNo)
                .orElseThrow(()->new RuntimeException("Shipping doesn't exist with sl no:- "+ slNo));
        existingShipping.setShippingId(shipping.getShippingId());
        existingShipping.setCusId((shipping.getCusId()));
        existingShipping.setShippingDateTime(shipping.getShippingDateTime());
        existingShipping.setQuantity(shipping.getQuantity());
        existingShipping.setOrderPrice(shipping.getOrderPrice());
        existingShipping.setShippingAddress(shipping.getShippingAddress());
        existingShipping.setCusName(shipping.getCusName());
        return shippingRepository.save(existingShipping);
    }
}