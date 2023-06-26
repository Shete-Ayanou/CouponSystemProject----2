package com.example.CouponSystemProject2.repos;

import com.example.CouponSystemProject2.beans.Coupon;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Integer> {


    boolean existsByTitle(String title);

    public List<Coupon> findByTitle(String title);

    List<Coupon> findByCompanyId(int companyId);


    @Query(value = "select * from coupons inner join customers_coupons on coupons_id = id where customer_id = ?", nativeQuery = true)
    List<Coupon> findCustomerPurchaseCoupons(int customerId);

    @Query(value = "select * from coupons inner join customers_coupons on coupons_id = id where customer_id = ? and category = ?", nativeQuery = true)
    List<Coupon> findCustomerPurchaseCouponsByCategory(int customerId, String Category);

    @Query(value = "select * from coupons inner join customers_coupons on coupons_id = id where customer_id = ? and price < ?", nativeQuery = true)
    List<Coupon> findCustomerPurchaseCouponsByPrice(int customerId, double maxPrice);

    @Query(value = "SELECT EXISTS (SELECT * FROM customers_coupons WHERE customer_id = ? AND coupons_id = ?)", nativeQuery = true)
    public int findIsCustomerAlreadyHaveCoupon(int customerId, int couponId);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO customers_coupons (customer_id, coupons_id) VALUES (?, ?)", nativeQuery = true)
    void addCouponPurchase(int customerId, int couponId);


//    @Transactional
//    @Modifying
//    @Query(value = "DELETE FROM `couponsystemproject----2`.customers_coupons WHERE (`coupons_id` = ?)", nativeQuery = true)
//    void deleteByCouponId(int couponId);
//
//
//    @Transactional
//    @Modifying
//    @Query(value = "DELETE FROM `couponsystemproject----2`.coupons WHERE (`company_id` = ?)")
//    void deleteByCompanyId(int companyId);
//

}



