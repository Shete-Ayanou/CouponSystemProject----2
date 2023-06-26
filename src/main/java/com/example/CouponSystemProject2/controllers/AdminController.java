package com.example.CouponSystemProject2.controllers;


import com.example.CouponSystemProject2.beans.Company;
import com.example.CouponSystemProject2.exceptions.CouponSystemException2;
import com.example.CouponSystemProject2.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    public List<Company> getAllCompanies() {
        return adminService.getAllCompanies();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addCompany(@RequestBody Company company) throws CouponSystemException2 {
        adminService.addCompany(company);
    }

    @GetMapping("/{companyId}")
    public Company getSingleCompany(@PathVariable int companyId) throws CouponSystemException2 {
        return adminService.getSingleCompany(companyId);
    }

    @DeleteMapping("/{companyId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompany(@PathVariable int companyId) throws CouponSystemException2 {
        adminService.deleteCompany(companyId);
    }

    @PutMapping("/{companyId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCompany(@PathVariable int companyId, @RequestBody Company company) throws CouponSystemException2 {
        adminService.updateCompany(companyId, company);
    }
}
