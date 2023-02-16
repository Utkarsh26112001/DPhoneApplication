package com.dphone.referral.service;

import com.dphone.referral.bean.ReferralBean;
import com.dphone.referral.entity.ReferralEntity;

import java.util.List;

public interface ReferralService {
    List<ReferralBean> getAllReferral();
    ReferralBean saveReferral(ReferralBean referralBean);
    ReferralBean deleteReferral(String referralUserName);
    ReferralBean searchReferralById(String referralUserName);
    ReferralBean updateReferral(ReferralBean referralBean);
    ReferralEntity searchReferralByEmail(String email);
    ReferralEntity searchReferralByMobile(String referralMobileNumber);
    ReferralEntity searchReferralByFirstName(String referralFirstName);

    Long generateReferralCode();
}
