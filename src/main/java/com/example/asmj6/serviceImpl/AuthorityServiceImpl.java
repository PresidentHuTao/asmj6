package com.example.asmj6.serviceImpl;

import com.example.asmj6.repository.AuthorityInterface;
import com.example.asmj6.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    AuthorityInterface aui;
}
