package com.example.CouponSystemProject2.service;

import com.example.CouponSystemProject2.beans.Category;
import com.example.CouponSystemProject2.beans.Coupon;
import com.example.CouponSystemProject2.beans.Customer;
import com.example.CouponSystemProject2.exceptions.CouponSystemException2;
import com.example.CouponSystemProject2.exceptions.ErrMsg;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor

@Service
public class CustomerServiceImpl extends ClientService implements CustomerService {

    private int customerId;

    @Override
    public boolean login(String email, String password) {
        List<Customer> customers = this.customerRepository.findAll();
        for (Customer customer : customers) {
            if (customer.getEmail().equals(email) && customer.getPassword().equals(password)) {
                customerId = customer.getId();
                return true;
            }
        }
        return false;
    }

    @Override
    public void purchaseCoupon(int customerId, Coupon coupon) throws CouponSystemException2 {
        if(this.couponRepository.findIsCustomerAlreadyHaveCoupon(customerId,coupon.getId()) == 1){
            throw new CouponSystemException2(ErrMsg.CUSTOMER_ALREADY_HAVE_COUPON);
        }
        if (coupon.getAmount() == 0) {
            throw new CouponSystemException2(ErrMsg.COUPON_OUT_OF_STOCK);
        }
        if (coupon.getEndDate().before(new Date())) {
            throw new CouponSystemException2(ErrMsg.COUPON_EXPIRED);
        }
        couponRepository.addCouponPurchase(customerId,coupon.getId());
        couponRepository.saveAndFlush(coupon);
        coupon.setAmount(coupon.getAmount()-1);



    }

    @Override
    public List<Coupon> getCustomerCoupons(int customerId) {
        System.err.println("customerId" + customerId);
        return this.couponRepository.findCustomerPurchaseCoupons(customerId);
    }

    //
    @Override
    public List<Coupon> getCustomerCoupons(int customerId, Category category) {
        List<Coupon> couponsByCategory = this.couponRepository.findCustomerPurchaseCouponsByCategory(customerId, category.name());
        return couponsByCategory.stream().filter(coupon -> coupon
                .getCategory() == category).collect(Collectors.toList());

    }

    @Override
    public List<Coupon> getCustomerCouponsByPrice(int customerId, double maxPrice) {
        List<Coupon> couponsByCPrice = this.couponRepository.findCustomerPurchaseCouponsByPrice(customerId, maxPrice);
        return couponsByCPrice.stream().filter(coupon -> coupon
                .getPrice() < maxPrice).collect(Collectors.toList());
    }

    @Override
    public Customer getCustomerDetails(int customerId) throws CouponSystemException2 {
        return this.customerRepository.findById(customerId).orElseThrow(() ->
                new CouponSystemException2(ErrMsg.CUSTOMER_ID_NOT_FOUND));
    }

    @Override
    public int getCustomerAlreadyHaveCoupon(int customerId, int couponId) {
        return couponRepository.findIsCustomerAlreadyHaveCoupon(customerId,couponId);
    }


}