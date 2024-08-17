package com.example.asmj6.restController;

import com.example.asmj6.entity.Order;
import com.example.asmj6.service.OrderService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/order")
public class OrderRestController {
    @Autowired
    OrderService os;
    @PostMapping("")
    public Order create(@RequestBody JsonNode orderData){
        return os.create(orderData);
    }
}
