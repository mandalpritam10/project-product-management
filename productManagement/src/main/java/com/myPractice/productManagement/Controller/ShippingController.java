package com.myPractice.productManagement.Controller;

import com.myPractice.productManagement.Entity.Shipping;
import com.myPractice.productManagement.Service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/shippings")
public class ShippingController {
    @Autowired
    private ServiceInterface shippinngService;
    @PostMapping
    public Shipping makeAShipping(@RequestBody Shipping shipping){
        return shippinngService.createShipping(shipping);
    }
    @GetMapping
    public List<Shipping> showAllShips(){
        return shippinngService.showAllTheShippings();
    }
    @GetMapping("/customer/{cus_id}")
    public List<Shipping> ShowAllShipsByCustomerId(@PathVariable Integer cus_id){
        return shippinngService.showShippingViaCusId(cus_id);
    }
    @GetMapping("/order/{shipping_id}")
    public Optional<Shipping> ShowAllShipsByOrderId(@PathVariable Integer shipping_id){
        return shippinngService.showShippingViaShippingId(shipping_id);
    }
    @PutMapping("/{sl_no}")
    public Shipping updateAShipById(@PathVariable Integer sl_no, @RequestBody Shipping shipping){
        return shippinngService.updateAnyShipping(sl_no,shipping);
    }
}
