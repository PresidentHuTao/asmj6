package com.example.asmj6.serviceImpl;

import com.example.asmj6.repository.AccountInterface;
import com.example.asmj6.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountInterface aci;
}
