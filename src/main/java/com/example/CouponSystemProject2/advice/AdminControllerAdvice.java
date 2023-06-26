package com.example.CouponSystemProject2.advice;

import com.example.CouponSystemProject2.exceptions.CouponSystemException2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdminControllerAdvice {

    @ExceptionHandler(value = {CouponSystemException2.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrDetails handleException(Exception e){
        return new ErrDetails(e.getMessage());
    }
}
