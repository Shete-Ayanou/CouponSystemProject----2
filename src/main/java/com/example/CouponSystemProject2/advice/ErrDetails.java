package com.example.CouponSystemProject2.advice;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErrDetails {
    private final String title = "COUPON PROJECT ERROR";
    private String description;
}
