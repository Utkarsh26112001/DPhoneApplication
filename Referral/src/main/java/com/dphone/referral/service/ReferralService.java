package com.dphone.referral.service;

import com.dphone.referral.bean.ReferralBean;
import com.dphone.referral.entity.ReferralEntity;

import java.util.List;

public interface ReferralService {
    List<ReferralEntity> getAllReferral();
    ReferralBean saveReferral(ReferralBean referralBean);
    ReferralBean deleteReferral(Long referralId);
    ReferralEntity searchReferralById(Long referralId);
    ReferralBean updateReferral(ReferralBean referralBean);
    ReferralEntity searchReferralByEmail(String email);
    ReferralEntity searchReferralByMobile(String referralMobileNumber);
    ReferralEntity searchReferralByFirstName(String referralFirstName);
}
