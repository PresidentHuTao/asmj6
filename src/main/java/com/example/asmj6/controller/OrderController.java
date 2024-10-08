package com.example.asmj6.controller;

import com.example.asmj6.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {
    @Autowired
    OrderService os;

    @RequestMapping("/order/checkout")
    public String checkOut() {
        return "order/checkout";
    }

    @RequestMapping("/order/list")
    public String list() {
        return "order/list";
    }

    @RequestMapping("/order/detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("order", os.findById(id));
        return "order/detail";
    }
}
