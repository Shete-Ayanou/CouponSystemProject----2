package com.example.CouponSystemProject2.clr;

import com.example.CouponSystemProject2.beans.Category;
import com.example.CouponSystemProject2.beans.Coupon;
import com.example.CouponSystemProject2.beans.Customer;
import com.example.CouponSystemProject2.login.LoginManager;
import com.example.CouponSystemProject2.repos.CustomerRepository;
import com.example.CouponSystemProject2.service.ClientService;
import com.example.CouponSystemProject2.service.CustomerService;
import com.example.CouponSystemProject2.utils.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


@Component
@Order(4)
public class CustomerServiceTest implements CommandLineRunner {


    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerService customerService;



    @Override
    public void run(String... args) throws Exception {

//
//        Test.test("Customer Service - bad login - wrong email");
//
//
//        Customer customer = new Customer("John Doe", "john@example.com", "password");
//        customerRepository.save(customer);
//


        Coupon coupon10 = Coupon.builder()
                .id(8)
                .category(Category.SPORTS)
                .title("--------------")
                .description("Upgrade your running game with our latest collection of running shoes")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
                .amount(100)
                .price(80.0)
                .image("https://media.giphy.com/media/fPeqMskwclbZj2TWg6/giphy.gif")
                .build();

        Customer c1 = Customer.builder()
                .id(1)
                .firstName("Alice")
                .lastName("Anderson")
                .email("alice@gmail.com")
                .password("1234")
                .build();

        customerService.purchaseCoupon(c1.getId(),coupon10);
        customerService.getCustomerCoupons(1).forEach(System.out::println);



//        Test.test("customer service - get customer coupon");
//        customerService.getCustomerCoupons(3).forEach(System.out::println);
//        System.out.println("---------------------------------");
//        customerService.getCustomerCoupons(3, Category.FOOD).forEach(System.out::println);
//
//
//        System.out.println("---------------------------------");
//        customerService.getCustomerCouponsByPrice(4,500).forEach(System.out::println);
//
//        System.out.println("---------------------------------");
//
//        System.out.println(customerService.getCustomerDetails(4));
//
//

//        System.out.println("Customer alrady have coupon");
//       System.out.println(customerService.getCustomerAlreadyHaveCoupon(5, 1));



    }



}
