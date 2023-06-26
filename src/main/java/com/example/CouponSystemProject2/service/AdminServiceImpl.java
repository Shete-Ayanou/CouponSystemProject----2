package com.example.CouponSystemProject2.service;

import com.example.CouponSystemProject2.beans.Company;
import com.example.CouponSystemProject2.beans.Customer;
import com.example.CouponSystemProject2.exceptions.CouponSystemException2;
import com.example.CouponSystemProject2.exceptions.ErrMsg;
import com.example.CouponSystemProject2.repos.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl extends ClientService implements AdminService {


    @Override
    public boolean login(String email, String password) {
        return email.equals("admin@admin.com") && password.equals("admin");
    }

    @Override
    public void addCompany(Company company) throws CouponSystemException2 {
        int id = company.getId();
        if (this.companyRepository.existsById(id)) {
            throw new CouponSystemException2(ErrMsg.ADD_COMPANY_ID_EXIST);
        }
        String name = company.getName();
        if (this.companyRepository.existsByName(name)) {
            throw new CouponSystemException2(ErrMsg.ADD_COMPANY_NAME_EXIST);
        }
        String email = company.getEmail();
        if (this.companyRepository.existsByEmail(email)) {
            throw new CouponSystemException2(ErrMsg.ADD_COMPANY_EMAIL_EXIST);
        }
        this.companyRepository.save(company);
    }

    // TODO: 18/06/23  dont forget
    @Override
    public void updateCompany(int companyId, Company company) throws CouponSystemException2 {
        if (!this.companyRepository.existsById(companyId)) {
            throw new CouponSystemException2(ErrMsg.UPDATE_COMPANY_ID_NOT_EXIST);
        }
        if (companyId != company.getId()) {
            throw new CouponSystemException2(ErrMsg.UPDATE_COMPANY_CANNOT_UPDATE_ID);
        }
        this.companyRepository.saveAndFlush(company);
    }

    @Override
    public void deleteCompany(int companyId) throws CouponSystemException2 {
        if (!companyRepository.existsById(companyId)) {
            throw new CouponSystemException2(ErrMsg.DELETE_COMPANY_CANNOT_DELETE_COMPANY_NOT_EXIST);
        }
//        this.couponRepository.deleteByCouponId();
        this.companyRepository.deleteById(companyId);

    }

    @Override
    public List<Company> getAllCompanies() {
        return this.companyRepository.findAll();
    }

    @Override
    public Company getSingleCompany(int id) throws CouponSystemException2 {
        return this.companyRepository.findById(id).orElseThrow(() -> new CouponSystemException2(ErrMsg.COMPANY_ID_NOT_FOUND));
    }

    @Override
    public void addCustomer(Customer customer) throws CouponSystemException2 {
        int id = customer.getId();
        if (this.customerRepository.existsById(id)) {
            throw new CouponSystemException2(ErrMsg.ADD_CUSTOMER_ID_EXIST);
        }
        String email = customer.getEmail();
        if (this.customerRepository.existsByEmail(email)) {
            throw new CouponSystemException2(ErrMsg.ADD_CUSTOMER_EMAIL_EXIST);
        }
        this.customerRepository.saveAndFlush(customer);

    }

    @Override
    public void updateCustomer(int customerId, Customer customer) throws CouponSystemException2 {
        if (!this.customerRepository.existsById(customerId)) {
            throw new CouponSystemException2(ErrMsg.UPDATE_CUSTOMER_ID_NOT_EXIST);
        }
        if (customerId != customer.getId()) {
            throw new CouponSystemException2(ErrMsg.UPDATE_CUSTOMER_CANNOT_UPDATE_ID);
        }
        this.customerRepository.saveAndFlush(customer);


    }

    @Override
    public void deleteCustomer(int customerId) throws CouponSystemException2 {
        if (!this.customerRepository.existsById(customerId)) {
            throw new CouponSystemException2(ErrMsg.DELETE_CUSTOMER_CANNOT_DELETE_CUSTOMER_NOT_EXIST);
        }
        customerRepository.deleteById(customerId);

    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getSingleCustomer(int customerId) throws CouponSystemException2 {
        return customerRepository.findById(customerId).orElseThrow(() -> new CouponSystemException2(ErrMsg.CUSTOMER_ID_NOT_FOUND));
    }
}
