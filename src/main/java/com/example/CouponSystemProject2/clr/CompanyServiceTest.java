package com.example.CouponSystemProject2.clr;


import com.example.CouponSystemProject2.beans.Category;
import com.example.CouponSystemProject2.beans.Company;
import com.example.CouponSystemProject2.beans.Coupon;
import com.example.CouponSystemProject2.service.ClientService;
import com.example.CouponSystemProject2.service.CompanyService;
import com.example.CouponSystemProject2.utils.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Component
@Order(3)
public class CompanyServiceTest implements CommandLineRunner {


    @Autowired
    private CompanyService companyService;


    @Override
    public void run(String... args) throws Exception {


        Test.test("Company Service - bad login - wrong email");
        Test.test("Company Service - bad login - wrong password");
        System.out.println((((ClientService) companyService).login("info@Ista.com", "3254")));
        System.out.println("---------------------------------------------------------------------------------");


//
//        Test.test("Admin Service - add coupon - wrong title");
//
//
//        Coupon G1 = Coupon.builder()
//                .category(Category.FOOD)
//                .title("1+1 All Burgers")
//                .description("TEST")
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
//                .amount(100)
//                .price(40.9)
//                .image("https://media.giphy.com/media/xT8qB6kzPwDT93Qht6/giphy.gif")
//                .build();
//        Coupon G2 = Coupon.builder()
//                .category(Category.FOOD)
//                .title("1+1 All Burgers")
//                .description("TEST")
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
//                .amount(100)
//                .price(40.9)
//                .image("https://media.giphy.com/media/xT8qB6kzPwDT93Qht6/giphy.gif")
//                .build();
//
//        Company company9 = Company.builder()
//                .name("GDB-Burger")
//                .email("info@GDB-Burger.com")
//                .password("1234")
//                .build();
//
//
//        try {
//            companyService.addCoupon(9, G1);
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        companyService.getCompanyCoupons(9).forEach(System.out::println);
//
//        Coupon coupon = Coupon.builder()
//                .title("10% off all natural supplements")
//                .
//                .category(Category.FOOD)
//                .description("Crazy sale of 1+1 all GDB hamburgers")
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
//                .amount(100)
//                .price(40.9)
//                .image("https://media.giphy.com/media/xT8qB6kzPwDT93Qht6/giphy.gif")
//                .build();
//                .build()
//
//        Test.test("Company Facade - bad add - wrong title");
////
//        Company company9 = Company.builder()
//                .name("GDB-Burger")
//                .email("info@GDB-Burger.com")
//                .password("1234")
//                .build();
////
//        Coupon coupon1 = Coupon.builder()
//                .company(company9)
//                .category(Category.FOOD)
//                .title("mamamam")
//                .description("Crazy sale of 1+1 all GDB hamburgers")
//                .startDate(Date.valueOf(LocalDate.now()))
//                .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
//                .amount(100)
//                .price(40.9)
//                .image("https://media.giphy.com/media/xT8qB6kzPwDT93Qht6/giphy.gif")
//                .build();
//
//
//
//        companyService.addCoupon(coupon1);
//        companyService.getCompanyCoupons(9).forEach(System.out::println);
//
//
//
//        try {
//            companyService.addCoupon(coupon1);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        companyService.getCompanyCoupons().forEach(System.out::println);
//
//
//        companyService.getCompanyCoupons(3).forEach(System.out::println);
//
//
//               Test.test("Company Facade - by catedory - wrong title");
//
//               companyService.getCompanyCoupons(Category.FOOD).forEach(System.out::println);
//
//        Test.test("Company Facade - delete  coupon ");
//
//        companyService.deleteCoupon(10,4);
//        System.out.println(companyService.getCompanyDetails(4));
//
//
//
//        Test.test("Company Facade - get Company coupon");
//
//        companyService.getCompanyCoupons(4).forEach(System.out::println);
//
//
//        Test.test("Company Facade - get coupon by Category  coupon ");
//
//        companyService.getCompanyCoupons(4, Category.VACATIONS).forEach(System.out::println);
//
//
//        Test.test("Company Facade - get coupon by Max-price  coupon ");
//
//        companyService.getCompanyCoupons(4, 500).forEach(System.out::println);
//
//        Test.test("Company Facade - get company details ");
//
//        System.out.println(companyService.getCompanyDetails(9));
//
//
//
//



    }
}
