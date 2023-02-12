package com.dphone.referral.bean;

import com.dphone.referral.entity.ReferralEntity;
import org.springframework.beans.BeanUtils;

public class BeanToEntityConvert {
    public ReferralEntity convertToEntity(ReferralBean referralBean){
        ReferralEntity referralEntity = new ReferralEntity();
        BeanUtils.copyProperties(referralBean,referralEntity);
        return referralEntity;
    }

    public ReferralBean convertToBean(ReferralEntity referralEntity){
        ReferralBean referralBean = new ReferralBean();
        BeanUtils.copyProperties(referralEntity,referralBean);
        return referralBean;
    }
}
