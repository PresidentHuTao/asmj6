package com.example.asmj6.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "OrderDetails")
@Entity
public class OrderDetail {
    @Id
    //từ giờ trường id cứ là số thì tự động tăng hết kiểu lại gặp lỗi phải đặt id trước khi persist
    //còn ko phải số thì hoặc là đặt thủ công hoặc gọi ra từ api
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Price")
    private Float price;
    @Column(name = "Quantity")
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "OrderId")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "ProductId")
    private Product product;
}
