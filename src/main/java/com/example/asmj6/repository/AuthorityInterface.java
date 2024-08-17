package com.example.asmj6.repository;

import com.example.asmj6.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityInterface extends JpaRepository<Authority, Integer> {
}
