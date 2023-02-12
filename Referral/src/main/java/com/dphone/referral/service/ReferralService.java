package com.dphone.referral.service;

import com.dphone.referral.bean.ReferralBean;
import com.dphone.referral.entity.ReferralEntity;

import java.util.List;

public interface ReferralService {
    List<ReferralEntity> getAllReferral();
    ReferralBean saveReferral(ReferralBean referralBean);
    ReferralBean deleteReferral(Long referralId);
    ReferralBean searchReferralById(Long referralId);
    ReferralBean updateReferral(ReferralBean referralBean);
    ReferralBean searchReferralByEmail(String referralEmail);
    ReferralBean searchReferralByMobile(String referralMobileNumber);
    ReferralBean searchReferralByFirstName(String referralFirstName);
}
