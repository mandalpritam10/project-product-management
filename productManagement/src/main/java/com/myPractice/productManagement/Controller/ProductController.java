package com.myPractice.productManagement.Controller;

import com.myPractice.productManagement.Entity.Product;
import com.myPractice.productManagement.Service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/products")
public class ProductController {
    @Autowired
    private ServiceInterface productService;
    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }
    @GetMapping
    public List<Product> getAllTheProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id){
        return productService.getAnyProductById(id);
    }
    @PutMapping
    public Product updateAnyProduct(@RequestBody Product product){
        return productService.updateAnyProduct(product);
    }
    @DeleteMapping("/{id}")
    public String deleteAnyProduct(@PathVariable Integer id){
        return productService.deleteAnyProductById(id);
    }
}