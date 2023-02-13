package com.dphone.referral.service;

import com.dphone.referral.bean.BeanToEntityConvert;
import com.dphone.referral.bean.ReferralBean;
import com.dphone.referral.dao.ReferralDao;
import com.dphone.referral.entity.ReferralEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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
            throw new IllegalStateException("referral with Id "+entity.getReferralId()+" already exists");
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
    public ReferralEntity searchReferralById(Long referralId) {
        Optional<ReferralEntity> referralEntity = referralDao.findById(referralId);
        if(referralEntity.isPresent()){
            return referralEntity.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Record Not Found");
        }
    }

    @Override
    public ReferralBean updateReferral(ReferralBean referralBean) {
        ReferralEntity entity = beanToEntityConvert.convertToEntity(referralBean);
        boolean exists = referralDao.existsById(entity.getReferralId());
        if(exists){
            referralDao.save(entity);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Record with this Id not present");
        }
        ReferralBean newReferralBean = beanToEntityConvert.convertToBean(entity);
        return newReferralBean;
    }

    @Override
    public ReferralEntity searchReferralByEmail(String referralEmail) {
        Optional<ReferralEntity> referralEntity = Optional.ofNullable(referralDao.findByEmail(referralEmail));
        if(referralEntity.isPresent()){
            return referralEntity.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Record Not Found");
        }
    }

    @Override
    public ReferralEntity searchReferralByMobile(String referralMobileNumber) {
        Optional<ReferralEntity> referralEntity = Optional.ofNullable(referralDao.findByMobile(referralMobileNumber));
        if(referralEntity.isPresent()){
            return referralEntity.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Record Not Found");
        }
    }

    @Override
    public ReferralEntity searchReferralByFirstName(String referralFirstName) {
        Optional<ReferralEntity> referralEntity = Optional.ofNullable(referralDao.findByFirstName(referralFirstName));
        if(referralEntity.isPresent()){
            return referralEntity.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Record Not Found");
        }
    }
}
