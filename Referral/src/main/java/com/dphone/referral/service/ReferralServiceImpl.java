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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class ReferralServiceImpl implements ReferralService{
    @Autowired
    private final ReferralDao referralDao;

    @Override
    public List<ReferralBean> getAllReferral() {

         List<ReferralEntity> list = referralDao.findAll();
         List<ReferralBean>  beanList = new ArrayList<>();

         for(ReferralEntity referralEntity : list){
             ReferralBean referralBean = convertToBean(referralEntity);

             beanList.add(referralBean);
         }
          return beanList;
    }

   // complete
    @Override
    public ReferralBean saveReferral(ReferralBean referralBean) {
        ReferralEntity entity =  convertToEntity(referralBean);
        // from object to object copying
//        boolean exists = referralDao.existsById(entity.getUsername());

        if(!referralDao.existsByEmail(entity.getEmail())){
            entity.setReferralCode("dPhone"+generateReferralCode());
            referralDao.save(entity);
        }
        else {
            throw new IllegalStateException("referral with Id "+entity.getUsername()+" already exists");
        }
      return  convertToBean(entity);

    }

    // not working
    //No EntityManager with actual transaction available for current thread - cannot reliably process 'remove' call
    @Override
    public ReferralBean deleteReferral(String email) {
        boolean exists = referralDao.existsByEmail(email);
        if(!exists){
            throw new IllegalStateException("employee with Id "+email+" does not exists");
        }
        referralDao.deleteByEmail(email);
        System.out.println("Deleted Successfully");
        return null;
    }


    // complete
    @Override
    public List<ReferralBean> searchReferralByFirstName(String referralFirstName, String username) {
        List<ReferralEntity> referralEntities= referralDao.findAllByReferralFirstNameAndUsername(referralFirstName,username);
        List<ReferralBean> referralBeans = new ArrayList<>();

        if(referralEntities.size()>0){

             for(ReferralEntity entity : referralEntities){
                 ReferralBean referralBean;
                 referralBean = convertToBean(entity);
                 referralBeans.add(referralBean);
             }

             return referralBeans;

        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Record Not Found");
        }
    }

    @Override
    public List<ReferralBean> findAllByUserName(String username) {

        List<ReferralEntity> referralEntities= referralDao.findAllByUsername(username);
        List<ReferralBean> referralBeans = new ArrayList<>();

        if(referralEntities.size()>0){

            for(ReferralEntity entity : referralEntities){
                ReferralBean referralBean;
                referralBean = convertToBean(entity);
                referralBeans.add(referralBean);
            }

            return referralBeans;

        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Record Not Found");
        }

    }

    // complete
    public ReferralBean updateReferral(ReferralBean referralBean) {
        ReferralEntity entity = convertToEntity(referralBean);
        boolean exists = referralDao.existsById(entity.getUsername());
        if(exists){
            referralDao.save(entity);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Record with this Id not present");
        }
      return convertToBean(entity);

    }

    // complete
    @Override
    public ReferralBean searchReferralByEmail(String email) {
        Optional<ReferralEntity> referralEntity = Optional.ofNullable(referralDao.findByEmail(email));
        if(referralEntity.isPresent()){
            return convertToBean(referralEntity.get());
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Record Not Found");
        }
    }

    @Override
    public ReferralBean searchReferralByMobile(String mobileNumber) {
        Optional<ReferralEntity> referralEntity = Optional.ofNullable(referralDao.findByMobileNumber(mobileNumber));
        if(referralEntity.isPresent()){
            return convertToBean(referralEntity.get());
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
