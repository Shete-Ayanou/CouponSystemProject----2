package com.example.CouponSystemProject2.service;

import com.example.CouponSystemProject2.beans.Company;
import com.example.CouponSystemProject2.beans.Customer;
import com.example.CouponSystemProject2.exceptions.CouponSystemException2;

import java.util.List;
import java.util.Optional;

public interface AdminService {

    void addCompany(Company company) throws CouponSystemException2;

    void updateCompany(int companyId, Company company) throws CouponSystemException2;

    void deleteCompany(int companyId) throws CouponSystemException2;

    List<Company> getAllCompanies();

    Company getSingleCompany(int companyId) throws CouponSystemException2;

    void addCustomer(Customer customer) throws CouponSystemException2;

    void updateCustomer(int customerId, Customer customer) throws CouponSystemException2;

    void deleteCustomer(int customerId) throws CouponSystemException2;

    List<Customer> getAllCustomer();

    Customer getSingleCustomer(int customerId) throws CouponSystemException2;

}
