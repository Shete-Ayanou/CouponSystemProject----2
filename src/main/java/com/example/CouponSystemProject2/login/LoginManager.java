package com.example.CouponSystemProject2.login;

import com.example.CouponSystemProject2.exceptions.CouponSystemException2;
import com.example.CouponSystemProject2.exceptions.ErrMsg;
import com.example.CouponSystemProject2.service.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class LoginManager {

    @Autowired
    private AdminService adminService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private CustomerService customerService;

    public ClientService login(String email, String password, ClientType clientType) throws CouponSystemException2 {
        switch (clientType) {
            case ADMINISTRATOR:
                if(((ClientService)adminService).login(email, password))
                    return (ClientService)adminService;
                break;

            case COMPANY:
                if(((ClientService)companyService).login(email, password))
                    return (ClientService)companyService;
                break;
            case CUSTOMER:
                if (((ClientService)customerService).login(email, password))
                    return (ClientService)customerService;
                break;
        }
        throw new CouponSystemException2(ErrMsg.LOGIN_MANAGER);
    }

}