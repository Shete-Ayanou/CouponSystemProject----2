package com.example.CouponSystemProject2.controllers;

import com.example.CouponSystemProject2.beans.Coupon;
import com.example.CouponSystemProject2.exceptions.CouponSystemException2;
import com.example.CouponSystemProject2.service.CustomerService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/{customerId}")
    @SneakyThrows
    public List<Coupon> getCustomerCoupons(@PathVariable int customerId) {
        return customerService.getCustomerCoupons(customerId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void purchaseCoupon( @RequestBody Coupon coupon)  {
//        customerService.purchaseCoupon( );
    }
}
