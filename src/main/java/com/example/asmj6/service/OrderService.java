package com.example.asmj6.service;

import com.example.asmj6.entity.Order;
import com.example.asmj6.entity.OrderDetail;
import com.fasterxml.jackson.databind.JsonNode;
public interface OrderService {
    Order create(JsonNode orderData);
    Order findById(Integer id);
}
