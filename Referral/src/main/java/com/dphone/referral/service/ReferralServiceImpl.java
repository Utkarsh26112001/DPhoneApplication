package com.dphone.referral.service;

import com.dphone.referral.bean.ReferralBean;
import com.dphone.referral.dao.ReferralDao;
import com.dphone.referral.entity.ReferralEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class ReferralServiceImpl implements ReferralService{
    @Autowired
    private final ReferralDao referralDao;

    @Override
    public List<ReferralEntity> getAllReferral() {
        return referralDao.findAll();
    }
    @Override
    public ReferralBean saveReferral(ReferralBean referralBean) {
        ReferralEntity entity =  convertToEntity(referralBean);
        // from object to object copying
        boolean exists = referralDao.existsById(entity.getUsername());
        if(!exists){
            entity.setReferralCode(generateReferralCode());
            referralDao.save(entity);
        }
        else {
            throw new IllegalStateException("referral with Id "+entity.getUsername()+" already exists");
        }
        ReferralBean newReferralBean = convertToBean(entity);
        return newReferralBean;
    }
//
    @Override
    public ReferralBean deleteReferral(String referralUserName) {
        boolean exists = referralDao.existsById(referralUserName);
        if(!exists){
            throw new IllegalStateException("employee with Id "+referralUserName+" does not exists");
        }
        referralDao.deleteById(referralUserName);
        System.out.println("Deleted Successfully");
        return null;
    }

    @Override
    public ReferralEntity searchReferralById(String referralUserName) {
        Optional<ReferralEntity> referralEntity = referralDao.findById(referralUserName);
        if(referralEntity.isPresent()){
            return referralEntity.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Record Not Found");
        }
    }

    public ReferralBean updateReferral(ReferralBean referralBean) {
        ReferralEntity entity = convertToEntity(referralBean);
        boolean exists = referralDao.existsById(entity.getUsername());
        if(exists){
            referralDao.save(entity);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Record with this Id not present");
        }
        ReferralBean newReferralBean = convertToBean(entity);
        return newReferralBean;
    }

    @Override
    public ReferralEntity searchReferralByEmail(String email) {
        Optional<ReferralEntity> referralEntity = Optional.ofNullable(referralDao.findByEmail(email));
        if(referralEntity.isPresent()){
            return referralEntity.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Record Not Found");
        }
    }

    @Override
    public ReferralEntity searchReferralByMobile(String mobileNumber) {
        Optional<ReferralEntity> referralEntity = Optional.ofNullable(referralDao.findByMobileNumber(mobileNumber));
        if(referralEntity.isPresent()){
            return referralEntity.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Record Not Found");
        }
    }


    @Override
    public ReferralEntity searchReferralByFirstName(String referralFirstName) {
        Optional<ReferralEntity> referralEntity = Optional.ofNullable(referralDao.findByReferralFirstName(referralFirstName));
        if(referralEntity.isPresent()){
            return referralEntity.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Record Not Found");
        }
 }

    @Override
    public Long generateReferralCode() {
        Random rand = new Random();
        // Generate random integers in range 0 to 999
        int rand_int1 = rand.nextInt(1000);
        return (long) rand_int1;
    }

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
