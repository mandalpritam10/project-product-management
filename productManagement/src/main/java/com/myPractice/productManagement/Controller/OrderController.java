package com.myPractice.productManagement.Controller;

import com.myPractice.productManagement.Entity.Order;
import com.myPractice.productManagement.Service.ServiceInterface;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/orders")
public class OrderController {
    @Autowired
    private ServiceInterface orderService;
    @GetMapping
    public List<Order> showAllOrders(){
        return orderService.getAllOrders();
    }
    @GetMapping("/{order_id}")
    public Order getOrderById(@PathVariable Integer order_id){
        return orderService.getAnyOrderById(order_id);
    }
    @PostMapping
    public Order saveOrder(@RequestBody Order order){
        return orderService.createOrder(order);
    }
    @PutMapping
    public Order updateOrder(@RequestBody Order order){
        return orderService.updateAnyOrder(order);
    }
    @DeleteMapping({"/{order_id}"})
    public String deleteOrder(@PathVariable Integer order_id){
        return orderService.deleteAnyOrderByID((order_id));
    }
}
