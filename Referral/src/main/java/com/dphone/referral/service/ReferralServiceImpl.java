package com.dphone.referral.service;

import com.dphone.referral.bean.BeanToEntityConvert;
import com.dphone.referral.bean.ReferralBean;
import com.dphone.referral.dao.ReferralDao;
import com.dphone.referral.entity.ReferralEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReferralServiceImpl implements ReferralService{
    @Autowired
    private final ReferralDao referralDao;
    private final BeanToEntityConvert beanToEntityConvert;

    @Override
    public List<ReferralEntity> getAllReferral() {
        return referralDao.findAll();
    }

    @Override
    public ReferralBean saveReferral(ReferralBean referralBean) {
        ReferralEntity entity = beanToEntityConvert.convertToEntity(referralBean);
        // from object to object copying
        boolean exists = referralDao.existsById(entity.getReferralId());
        if(!exists){
            referralDao.save(entity);
        }
        else {
            System.out.println("Record already present");
        }

        ReferralBean newReferralBean = beanToEntityConvert.convertToBean(entity);
        return newReferralBean;
    }

    @Override
    public ReferralBean deleteReferral(Long referralId) {
        boolean exists = referralDao.existsById(referralId);
        if(!exists){
            throw new IllegalStateException("employee with Id "+referralId+" does not exists");
        }
        referralDao.deleteById(referralId);
        System.out.println("Deleted Successfully");
        return null;
    }

    @Override
    public ReferralBean searchReferralById(Long referralId) {
        return null;
    }

    @Override
    public ReferralBean updateReferral(ReferralBean referralBean) {
        return null;
    }

    @Override
    public ReferralBean searchReferralByEmail(String referralEmail) {
        return null;
    }

    @Override
    public ReferralBean searchReferralByMobile(String referralMobileNumber) {
        return null;
    }

    @Override
    public ReferralBean searchReferralByFirstName(String referralFirstName) {
        return null;
    }
}
