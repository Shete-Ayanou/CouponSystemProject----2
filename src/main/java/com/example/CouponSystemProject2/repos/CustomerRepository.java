package com.example.CouponSystemProject2.repos;

import com.example.CouponSystemProject2.beans.Coupon;
import com.example.CouponSystemProject2.beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerRepository extends JpaRepository <Customer, Integer> {

    boolean existsByEmail(String email);


}
