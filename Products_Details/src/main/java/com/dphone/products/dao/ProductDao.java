package com.dphone.products.dao;

import com.dphone.products.bean.ProductBean;
import com.dphone.products.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<ProductEntity,Long> {
    boolean existsByReferralCode(String referralCode);
}
