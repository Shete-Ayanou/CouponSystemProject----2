package com.example.CouponSystemProject2.service;

import com.example.CouponSystemProject2.beans.Category;
import com.example.CouponSystemProject2.beans.Coupon;
import com.example.CouponSystemProject2.beans.Customer;
import com.example.CouponSystemProject2.exceptions.CouponSystemException2;

import java.util.List;

public interface CustomerService {

    void purchaseCoupon(int customerId, Coupon coupon) throws CouponSystemException2;

    List<Coupon> getCustomerCoupons(int customerId);

    List<Coupon> getCustomerCoupons(int customerId, Category category);
//
    List<Coupon> getCustomerCouponsByPrice(int customerId, double maxPrice);

    Customer getCustomerDetails(int customerId) throws CouponSystemException2;

    int getCustomerAlreadyHaveCoupon(int customerId, int couponId);



}
