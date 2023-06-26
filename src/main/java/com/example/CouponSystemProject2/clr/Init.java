package com.example.CouponSystemProject2.clr;

import com.example.CouponSystemProject2.beans.Category;
import com.example.CouponSystemProject2.beans.Company;
import com.example.CouponSystemProject2.beans.Coupon;
import com.example.CouponSystemProject2.beans.Customer;
import com.example.CouponSystemProject2.repos.CompanyRepository;
import com.example.CouponSystemProject2.repos.CouponRepository;
import com.example.CouponSystemProject2.repos.CustomerRepository;
import com.example.CouponSystemProject2.utils.Art;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Component
@Order(1)
public class Init implements CommandLineRunner {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CouponRepository couponRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {

        loadCustomer();

    }


    public void loadCustomer() {


        System.out.println(Art.COMPANIES);
        Company company1 = Company.builder()
                .name("Apple")
                .email("info@apple.com")
                .password("1234")
                .build();
        Company company2 = Company.builder()
                .name("Microsoft")
                .email("info@Microsoft.com")
                .password("1234")
                .build();
        Company company3 = Company.builder()
                .name("good-pharm")
                .email("info@good-pharm.com")
                .password("1234")
                .build();
        Company company4 = Company.builder()
                .name("Ista")
                .email("info@Ista.com")
                .password("1234")
                .build();
        Company company5 = Company.builder()
                .name("Super-pharm")
                .email("info@Super-pharm.com")
                .password("1234")
                .build();
        Company company6 = Company.builder()
                .name("PizaHat")
                .email("info@PizaHat.com")
                .password("1234")
                .build();
        Company company7 = Company.builder()
                .name("Polo")
                .email("info@Polo.com")
                .password("1234")
                .build();
        Company company8 = Company.builder()
                .name("Holiday-finder")
                .email("info@Holiday-finder.com")
                .password("1234")
                .build();
        Company company9 = Company.builder()
                .name("GDB-Burger")
                .email("info@GDB-Burger.com")
                .password("1234")
                .build();
        Company company10 = Company.builder()
                .name("Fitbody")
                .email("info@Fitbody.com")
                .password("1234")
                .build();
        companyRepository.saveAll(List.of(company1, company2, company3, company4, company5, company6, company7, company8, company9, company10));
        companyRepository.findAll().forEach(System.out::println);


        System.out.println(Art.COUPONS);

        Coupon coupon1 = Coupon.builder()
                .company(company9)
                .category(Category.FOOD)
                .title("1+1 All Burgers")
                .description("Crazy sale of 1+1 all GDB hamburgers")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
                .amount(100)
                .price(40.9)
                .image("https://media.giphy.com/media/xT8qB6kzPwDT93Qht6/giphy.gif")
                .build();
        Coupon coupon2 = Coupon.builder()
                .company(company4)
                .category(Category.COMPUTERS)
                .title("Buy one get one free on keyboards")
                .description("Get 20% discount on all laptops")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
                .amount(100)
                .price(2000.0)
                .image("https://media.giphy.com/media/mCRJDo24UvJMA/giphy.gif")
                .build();

        Coupon coupon3 = Coupon.builder()
                .company(company2)
                .category(Category.COMPUTERS)
                .title("Buy one get one free on mouse")
                .description("Buy one keyboard and get another one for free")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
                .amount(100)
                .price(50.0)
                .image("https://media.giphy.com/media/9rtpurjbqiqZXbBBet/giphy.gif")
                .build();
        Coupon coupon4 = Coupon.builder()
                .company(company6)
                .category(Category.FOOD)
                .title("50% off all pizzas")
                .description("Get 50% discount on all pizza orders")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
                .amount(100)
                .price(50.0)
                .image("https://media.giphy.com/media/9fuvOqZ8tbZOU/giphy.gif")
                .build();
        Coupon coupon5 = Coupon.builder()
                .company(company3)
                .category(Category.HEALTH)
                .title("Get 3 for the price of 2 on all vitamins")
                .description("Buy 3 vitamin products and get the cheapest one for free")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
                .amount(100)
                .price(20.0)
                .image("https://media.giphy.com/media/3oz8xwkewgvaFB75Nm/giphy.gif")
                .build();
        Coupon coupon6 = Coupon.builder()
                .company(company5)
                .category(Category.HEALTH)
                .title("10% off all natural supplements")
                .description("Get 10% discount on all natural supplements")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
                .amount(100)
                .price(80.0)
                .image("https://www.example.com/supplements.jpg")
                .build();
        Coupon coupon7 = Coupon.builder()
                .company(company4)
                .category(Category.VACATIONS)
                .title("Summer Sale - 50% off all resorts!")
                .description("GBook your next vacation and get 50% off all resort packages!")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
                .amount(100)
                .price(200.0)
                .image("https://media.giphy.com/media/j0QzDgFZRX2njRxxtP/giphy.gif")
                .build();
        Coupon coupon8 = Coupon.builder()
                .company(company4)
                .category(Category.VACATIONS)
                .title("Winter Wonderland - 25% off all ski trips!")
                .description("Escape to the mountains and get 25% off all ski trips!")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
                .amount(100)
                .price(500.0)
                .image("https://media.giphy.com/media/hs3qvWPf6X4fWP1cwk/giphy.gif")
                .build();
        Coupon coupon9 = Coupon.builder()
                .company(company10)
                .category(Category.SPORTS)
                .title("Get in shape! 20% off all gym memberships")
                .description("Join now and get 20% off all gym memberships!")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
                .amount(100)
                .price(100.0)
                .image("https://giphy.com/clips/perfectketo-workout-training-working-out-y48NCmNho57e12ALdR")
                .build();
        Coupon coupon10 = Coupon.builder()
                .company(company4)
                .category(Category.SPORTS)
                .title("New Running Shoes - 15% off!")
                .description("Upgrade your running game with our latest collection of running shoes")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
                .amount(100)
                .price(80.0)
                .image("https://media.giphy.com/media/fPeqMskwclbZj2TWg6/giphy.gif")
                .build();
        couponRepository.saveAll(List.of(coupon1,coupon2,coupon3,coupon4,coupon5,coupon6,coupon7,coupon8,coupon9,coupon10));
        couponRepository.findAll().forEach(System.out::println);

        System.out.println(Art.CUSTOMERS);

        Customer customer1 = Customer.builder()
                .firstName("Alice")
                .lastName("Anderson")
                .email("alice@gmail.com")
                .password("1234")
                .coupons(List.of(coupon1,coupon2))
                .build();
        Customer customer2 = Customer.builder()
                .firstName("Bob")
                .lastName("Brown")
                .email("bob@gmail.com")
                .password("1234")
                .coupons(List.of(coupon1,coupon2))
                .build();
        Customer customer3 = Customer.builder()
                .firstName("Charlie")
                .lastName("Clark")
                .email("charlie@gmail.com")
                .password("1234")
                .coupons(List.of(coupon3,coupon4))
                .build();
        Customer customer4 = Customer.builder()
                .firstName("David")
                .lastName("Davis")
                .email("david@gmail.com")
                .password("1234")
                .coupons(List.of(coupon3,coupon4))

                .build();
        Customer customer5 = Customer.builder()
                .firstName("Emily")
                .lastName("Evans")
                .email("emily@gmail.com")
                .password("1234")
                .coupons(List.of(coupon5,coupon6))

                .build();
        Customer customer6 = Customer.builder()
                .firstName("Frank")
                .lastName("Ford")
                .email("frank@gmail.com")
                .password("1234")
                .build();
        Customer customer7 = Customer.builder()
                .firstName("Grace")
                .lastName("Green")
                .email("grace@gmail.com")
                .password("1234")
                .build();
        Customer customer8 = Customer.builder()
                .firstName("Henry")
                .lastName("Harris")
                .email("henry@gmail.com")
                .password("1234")
                .build();
        Customer customer9 = Customer.builder()
                .firstName("Isaac")
                .lastName("Irving")
                .email("isaac@gmail.com")
                .password("1234")
                .build();
        Customer customer10 = Customer.builder()
                .firstName("Jack")
                .lastName("Johnson")
                .email("jack@gmail.com")
                .password("1234")
                .build();

        customerRepository.saveAll(List.of(customer1, customer2, customer3, customer4, customer5, customer6, customer7, customer8, customer9, customer10));
        customerRepository.findAll().forEach(System.out::println);



    }



}
