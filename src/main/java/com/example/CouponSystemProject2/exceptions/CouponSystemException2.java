package com.example.CouponSystemProject2.exceptions;

public class CouponSystemException2 extends Exception{

    public CouponSystemException2(ErrMsg errMsg) {
        super(errMsg.getMessage());
    }
}
