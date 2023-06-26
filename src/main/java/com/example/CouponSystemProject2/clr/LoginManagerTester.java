package com.example.CouponSystemProject2.clr;

import com.example.CouponSystemProject2.login.LoginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(5)
public class LoginManagerTester implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

    }
}
