package com.example.CouponSystemProject2.service;

import com.example.CouponSystemProject2.beans.Category;
import com.example.CouponSystemProject2.beans.Company;
import com.example.CouponSystemProject2.beans.Coupon;
import com.example.CouponSystemProject2.exceptions.CouponSystemException2;

import java.util.List;

public interface CompanyService {

    void addCoupon(int companyId, Coupon coupon) throws CouponSystemException2;

    void updateCoupon(int couponId, Coupon coupon) throws CouponSystemException2;

    void deleteCoupon(int couponId, int companyId) throws CouponSystemException2;

    List<Coupon> getCompanyCoupons(int companyId) throws CouponSystemException2;

    List<Coupon> getCompanyCoupons (int companyId, Category category);

    List<Coupon> getCompanyCoupons(int companyId, double MaxPrice);

    Company getCompanyDetails(int companyId) throws CouponSystemException2;




}
