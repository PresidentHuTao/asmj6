package com.example.asmj6.serviceImpl;

import com.example.asmj6.entity.Order;
import com.example.asmj6.entity.OrderDetail;
import com.example.asmj6.repository.OrderDetailInterface;
import com.example.asmj6.repository.OrderInterface;
import com.example.asmj6.service.OrderDetailService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

}
