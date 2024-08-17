package com.example.asmj6.repository;

import com.example.asmj6.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountInterface extends JpaRepository<Account, String> {
}
