package com.example.asmj6.serviceImpl;

import com.example.asmj6.entity.Product;
import com.example.asmj6.repository.ProductInterface;
import com.example.asmj6.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductInterface pi;

    @Override
    public List<Product> findAll() {
        return pi.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return pi.findById(id).get();
    }

    @Override
    public List<Product> findByCategoryId(String cid) {
        return pi.findByCategoryId(cid);
    }
}
