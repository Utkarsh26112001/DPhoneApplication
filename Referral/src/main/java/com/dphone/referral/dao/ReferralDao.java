package com.dphone.referral.dao;

import com.dphone.referral.entity.ReferralEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReferralDao extends JpaRepository<ReferralEntity,Long>{

}
