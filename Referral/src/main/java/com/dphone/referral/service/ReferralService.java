package com.dphone.referral.service;

import com.dphone.referral.bean.ReferralBean;


import java.util.List;

public interface ReferralService {
    List<ReferralBean> getAllReferral();
    ReferralBean saveReferral(ReferralBean referralBean);
    ReferralBean deleteReferral(String email);
    ReferralBean updateReferral(ReferralBean referralBean);
    ReferralBean searchReferralByEmail(String email);
    ReferralBean searchReferralByMobile(String referralMobileNumber);
    List<ReferralBean> searchReferralByFirstName(String referralFirstName,String userName);
    ReferralBean findByReferralCode(String referralCode);
    List<ReferralBean> findAllByUserName(String username);
    Long generateReferralCode();
}
