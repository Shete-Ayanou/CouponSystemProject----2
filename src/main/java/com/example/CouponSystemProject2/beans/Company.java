package com.example.CouponSystemProject2.beans;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "companies")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 40, nullable = false)
    private String name;

    private String email;

    private String password;


    @OneToMany (cascade = {CascadeType.PERSIST,CascadeType.REMOVE}, orphanRemoval = true, mappedBy = "company")
    private List<Coupon> coupons;

}
