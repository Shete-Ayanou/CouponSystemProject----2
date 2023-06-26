package com.example.CouponSystemProject2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CouponSystemProject2Application {

	public static void main(String[] args) {

		System.out.println("START");
		ApplicationContext ctx =  SpringApplication.run(CouponSystemProject2Application.class, args);

		System.out.println("END");
	}

}
