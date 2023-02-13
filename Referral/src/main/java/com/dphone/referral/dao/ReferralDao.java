package com.dphone.referral.dao;

import com.dphone.referral.entity.ReferralEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferralDao extends JpaRepository<ReferralEntity, Long> {
    public ReferralEntity findByEmail(String email);


    public ReferralEntity findByMobileNumber(String mobileNumber);

    public ReferralEntity findByReferralFirstName(String referralFirstName);

}
