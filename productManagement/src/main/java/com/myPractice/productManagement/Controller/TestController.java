package com.myPractice.productManagement.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/hi")
    public String message(){
        return "Hello World";
    }
}
