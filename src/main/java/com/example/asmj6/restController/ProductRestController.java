package com.example.asmj6.restController;

import com.example.asmj6.entity.Product;
import com.example.asmj6.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/product")
public class ProductRestController {
    @Autowired
    ProductService ps;

    //ko có hàm này thì bấm thêm sp mới ko lưu vào giỏ hàng được, chi tiết xem tại dòng 20 class shopping-cart-app.js
    @GetMapping("{id}")
    public Product getOne(@PathVariable("id") Integer id) {
        return ps.findById(id);
    }

    @GetMapping("")
    public List<Product> getAll() {
        return ps.findAll();
    }
}
