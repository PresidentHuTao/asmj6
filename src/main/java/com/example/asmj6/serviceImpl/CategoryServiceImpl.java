package com.example.asmj6.serviceImpl;

import com.example.asmj6.entity.Category;
import com.example.asmj6.repository.CategoryInterface;
import com.example.asmj6.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryInterface ci;

    @Override
    public List<Category> findAll() {
        return ci.findAll();
    }
}
