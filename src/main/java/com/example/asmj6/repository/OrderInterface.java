package com.example.asmj6.repository;

import com.example.asmj6.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderInterface extends JpaRepository<Order, Integer> {
}
