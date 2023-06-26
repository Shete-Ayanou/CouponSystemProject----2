package com.example.CouponSystemProject2.service;

import com.example.CouponSystemProject2.repos.CompanyRepository;
import com.example.CouponSystemProject2.repos.CouponRepository;
import com.example.CouponSystemProject2.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ClientService {
    @Autowired
    protected CouponRepository couponRepository;
    @Autowired
    protected CompanyRepository companyRepository;
    @Autowired
    protected CustomerRepository customerRepository;


    public abstract boolean login (String email, String password);
}
