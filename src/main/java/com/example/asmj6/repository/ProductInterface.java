package com.example.asmj6.repository;

import com.example.asmj6.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductInterface extends JpaRepository<Product, Integer> {
    //jpa ko hỗ trợ sẵn nên tự viết
    //query trong entity chứ ko phải csdl
    @Query("select p from Product p where p.category.id=?1")
    List<Product> findByCategoryId(String cid);
}
