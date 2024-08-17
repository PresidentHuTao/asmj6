package com.example.asmj6.repository;

import com.example.asmj6.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryInterface extends JpaRepository<Category, String> {
}
