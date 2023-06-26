package com.example.CouponSystemProject2.service;

import com.example.CouponSystemProject2.beans.Category;
import com.example.CouponSystemProject2.beans.Company;
import com.example.CouponSystemProject2.beans.Coupon;
import com.example.CouponSystemProject2.exceptions.CouponSystemException2;
import com.example.CouponSystemProject2.exceptions.ErrMsg;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor

@Service
public class CompanyServiceImpl extends ClientService implements CompanyService {

    private int companyId;


    @Override
    public boolean login(String email, String password) {
        List<Company> companies = companyRepository.findAll();
        for (Company company : companies) {
            if (company.getEmail().equals(email) && company.getPassword().equals(password)) {
                companyId = company.getId();
                return true;
            }
        }
        return false;
    }


    // TODO: 18/06/23  --------------------------------------------------
    @Override
    public void addCoupon(int companyId, Coupon coupon) throws CouponSystemException2 {
        String title = coupon.getTitle();
        if (this.couponRepository.existsByTitle(title)) {
            List<Coupon> coupons = couponRepository.findByTitle(title);
            for (Coupon coupon1 : coupons) {
                if (coupon1.getId() == coupon.getId())
                    throw new CouponSystemException2(ErrMsg.ADD_COUPON_TITLE_EXIST);

            }
        }
        this.couponRepository.save(coupon);


    }

    @Override
    public void updateCoupon(int couponId, Coupon coupon) throws CouponSystemException2 {
        Optional<Coupon> couponToUpdate = couponRepository.findById(couponId);
        if (couponToUpdate.isEmpty()) {
            throw new CouponSystemException2(ErrMsg.UPDATE_COMPANY_ID_NOT_EXIST);
        }
        Coupon c = couponToUpdate.get();
        c.setTitle(coupon.getTitle());
        c.setCategory(coupon.getCategory());
        c.setAmount(coupon.getAmount());
        c.setDescription(coupon.getDescription());
        c.setPrice(coupon.getPrice());
        c.setStartDate(coupon.getStartDate());
        c.setEndDate(coupon.getEndDate());
        c.setImage(coupon.getImage());
        couponRepository.saveAndFlush(coupon);

    }

    @Override
    public void deleteCoupon(int couponId, int companyId) throws CouponSystemException2 {
        if (!this.couponRepository.existsById(couponId)) {
            throw new CouponSystemException2(ErrMsg.DELETE_COUPON_BY_ID);
        }
        couponRepository.deleteById(couponId);

    }

    @Override
    public List<Coupon> getCompanyCoupons(int companyId) throws CouponSystemException2 {
        if(!companyRepository.existsById(companyId)){
            throw new CouponSystemException2(ErrMsg.COMPANY_ID_NOT_FOUND);
        }
        return couponRepository.findByCompanyId(companyId);
    }

    @Override
    public List<Coupon> getCompanyCoupons(int companyId, Category category) {
        List<Coupon> couponsByCategory = couponRepository.findByCompanyId(companyId);
        return couponsByCategory.stream().filter(coupon -> coupon.
                getCategory() == category).collect(Collectors.toList());

    }

    @Override
    public List<Coupon> getCompanyCoupons(int companyId, double MaxPrice) {
        List<Coupon> couponsByPrice = couponRepository.findByCompanyId(companyId);
        return couponsByPrice.stream().filter(coupon ->
                coupon.getPrice() < MaxPrice).collect(Collectors.toList());
    }

    @Override
    public Company getCompanyDetails(int companyId) throws CouponSystemException2 {
        return companyRepository.findById(companyId).orElseThrow(() ->
                new CouponSystemException2(ErrMsg.COMPANY_ID_NOT_FOUND));
    }
}
