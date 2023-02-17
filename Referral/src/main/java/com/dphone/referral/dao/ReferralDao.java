package com.dphone.referral.dao;

import com.dphone.referral.entity.ReferralEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReferralDao extends JpaRepository<ReferralEntity, String > {
     ReferralEntity findByEmail(String email);

     ReferralEntity findByMobileNumber(String mobileNumber);

     List<ReferralEntity> findAllByReferralFirstNameAndUsername(String referralFirstName,String username);

     List<ReferralEntity> findAllByUsername(String username);
     void deleteByEmail(String email);
     ReferralEntity findByReferralCode(String  referralCode);


    public boolean existsByEmail(String email);
}
