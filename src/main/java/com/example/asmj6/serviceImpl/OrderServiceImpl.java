package com.example.asmj6.serviceImpl;

import com.example.asmj6.entity.Order;
import com.example.asmj6.entity.OrderDetail;
import com.example.asmj6.repository.OrderDetailInterface;
import com.example.asmj6.repository.OrderInterface;
import com.example.asmj6.service.OrderService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderInterface oi;
    @Autowired
    OrderDetailInterface odi;

    @Override
    public Order create(JsonNode orderData) {
        ObjectMapper mapper = new ObjectMapper();
        Order order = mapper.convertValue(orderData, Order.class);
        oi.save(order);
        TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {
        };
        List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetail"), type)
                .stream().peek(d -> d.setOrder(order)).collect(Collectors.toList());
        odi.saveAll(details);
        return order;
    }

    @Override
    public Order findById(Integer id) {
        return oi.findById(id).get();
    }
}
