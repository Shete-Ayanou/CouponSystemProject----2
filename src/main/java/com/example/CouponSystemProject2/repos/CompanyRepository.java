package com.example.CouponSystemProject2.repos;

import com.example.CouponSystemProject2.beans.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository  extends JpaRepository <Company, Integer> {

    boolean existsByName(String name);

    boolean existsByEmail(String email);
}
