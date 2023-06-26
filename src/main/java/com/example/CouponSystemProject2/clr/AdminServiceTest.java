package com.example.CouponSystemProject2.clr;


import com.example.CouponSystemProject2.beans.Company;
import com.example.CouponSystemProject2.beans.Customer;
import com.example.CouponSystemProject2.service.AdminService;
import com.example.CouponSystemProject2.service.ClientService;
import com.example.CouponSystemProject2.utils.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class AdminServiceTest implements CommandLineRunner {

    @Autowired
    private AdminService adminService;

    @Override
    public void run(String... args) throws Exception {

        Test.test("Admin Facade - bad login - wrong email");
        System.out.println(((ClientService) adminService).login("stam@admin.com", "admin"));
        Test.test("Admin Facade - bad login - wrong password");
        System.out.println(((ClientService) adminService).login("admin@admin.com", "stam"));
        Test.test("Admin Facade - bad login - wrong email and password");
        System.out.println(((ClientService) adminService).login("stam@gmail.com", "stam"));
        Test.test("Admin Facade - good login -");
        System.out.println(((ClientService) adminService).login("admin@admin.com", "admin"));
        System.out.println("---------------------------------------------------------------------------------");

        Test.test("Admin Service - add company - id already exist");

        Company c1 = Company.builder().id(2).name("Mika").email("info@mika.com").password("12234").build();
        try {
            adminService.addCompany(c1);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Test.test("Admin Service - add company - name already exist");
        Company c2 = Company.builder().id(12).name("Apple").email("apla@info.com").password("1234").build();
        try {
            adminService.addCompany(c2);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Test.test("Admin Service - add company - email already exist");
        Company c3 = Company.builder().id(14).name("HOT").email("info@apple.com").password("1212").build();
        try {
            adminService.addCompany(c3);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Test.test("Admin Service - add company - success");
        Company c4 = Company.builder().id(14).name("Intuit").email("info@Intuit.com").password("1212").build();
        adminService.addCompany(c4);
        adminService.getAllCompanies().forEach(System.out::println);

        System.out.println("---------------------------------------------------------------------------------");
        Test.test("Admin Service - update company - cannot update id that not exist");


        System.out.println("---------------------------------------------------------------------------------");

        Test.test("Admin Service - delete company - ");

        try {
            adminService.deleteCompany(5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        adminService.getAllCompanies().forEach(System.out::println);

        System.out.println("---------------------------------------------------------------------------------");

        Test.test("Admin Facade - get all companies - ");

        adminService.getAllCompanies().forEach(System.out::println);

        System.out.println("---------------------------------------------------------------------------------");


        Test.test("Admin Service - get single company - ");

        try {
            System.out.println(adminService.getSingleCompany(25));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("---------------------------------------------------------------------------------");

        Test.test("Admin Facade - add customer - id already exist");
        Customer b1 = Customer.builder()
                .id(13)
                .firstName("Dana")
                .lastName("mami")
                .email("asasas@sdsd.com")
                .password("1234")
                .build();
        adminService.addCustomer(b1);

        adminService.getAllCustomer().forEach(System.out::println);

        System.out.println("---------------------------------------------------------------------------------");

        Test.test("Admin Service - delete customer - ");

        try {
            adminService.deleteCustomer(23);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        adminService.getAllCustomer().forEach(System.out::println);

        System.out.println("---------------------------------------------------------------------------------");

        Test.test("Admin Facade - get all customers - ");
        adminService.getAllCustomer().forEach(System.out::println);

        System.out.println("---------------------------------------------------------------------------------");

        Test.test("Admin Facade - get single customer  - ");
        try {
            System.out.println(adminService.getSingleCustomer(25));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
