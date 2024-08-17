package com.example.asmj6.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "Authorities")
@Entity
public class Authority {
    @Id
    @Column(name = "Id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "Username")
    private Account account;
    @ManyToOne
    @JoinColumn(name = "RoleId")
    private Role role;
}
