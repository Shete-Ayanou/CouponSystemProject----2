package com.example.CouponSystemProject2.controllers;

import com.example.CouponSystemProject2.beans.Company;
import com.example.CouponSystemProject2.beans.Coupon;
import com.example.CouponSystemProject2.exceptions.CouponSystemException2;
import com.example.CouponSystemProject2.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;


    @GetMapping("/{companyId}")
    public List<Coupon> getCompanyCoupons( @PathVariable int companyId) throws CouponSystemException2 {
    return companyService.getCompanyCoupons(companyId);
    }
}
