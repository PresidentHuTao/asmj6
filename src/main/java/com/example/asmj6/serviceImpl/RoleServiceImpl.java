package com.example.asmj6.serviceImpl;

import com.example.asmj6.repository.RoleInterface;
import com.example.asmj6.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleInterface ri;
}
