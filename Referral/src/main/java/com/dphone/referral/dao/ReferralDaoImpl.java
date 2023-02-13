package com.dphone.referral.dao;


import com.dphone.referral.bean.BeanToEntityConvert;
import com.dphone.referral.bean.ReferralBean;
import com.dphone.referral.entity.ReferralEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ReferralDaoImpl{

    @Autowired
    ReferralDao referralDao;


}
