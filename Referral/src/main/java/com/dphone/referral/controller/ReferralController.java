package com.dphone.referral.controller;


import com.dphone.referral.bean.ReferralBean;
import com.dphone.referral.entity.ReferralEntity;
import com.dphone.referral.service.ReferralServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/referral")
public class ReferralController {

    @Autowired
    private ReferralServiceImpl referralService;
    @GetMapping("/home")
    public String test(){
        return "hello";
    }

    @GetMapping("/getAllReferral")
    public List<ReferralBean> diaplayAll(){
        return referralService.getAllReferral();

    }

    @GetMapping("/referrals/{username}")
    public ResponseEntity<ReferralBean> searchById(@PathVariable("username")  String username){
        ReferralBean referralBean =  referralService.searchReferralById(username);
        return new ResponseEntity<>(referralBean, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ReferralEntity> searchByEmail(@PathVariable("email") String email){
        ReferralEntity referralEntity = (ReferralEntity) referralService.searchReferralByEmail(email);
        return new ResponseEntity<>(referralEntity, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<ReferralEntity> searchByFname(@PathVariable("name") String firstname){
        ReferralEntity referralEntity = (ReferralEntity) referralService.searchReferralByFirstName(firstname);
        return new ResponseEntity<>(referralEntity, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/phone/{mobile}")
    public ResponseEntity<ReferralEntity> searchByMobile(@PathVariable("mobile") String mobile){
        ReferralEntity referralEntity = (ReferralEntity) referralService.searchReferralByMobile(mobile);
        return new ResponseEntity<>(referralEntity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/saveReferral")
    public ResponseEntity<ReferralBean> addReferral(@RequestBody ReferralBean referralBean){
        ReferralBean referralBean1 = referralService.saveReferral(referralBean);
        return new ResponseEntity<>(referralBean1, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteReferral/{username}")
    public ResponseEntity<ReferralBean> deleteReferral(@PathVariable("username") String username){
        ReferralBean referralBean = referralService.deleteReferral(username);
        return new ResponseEntity<>(referralBean, new HttpHeaders(), HttpStatus.OK);
    }
    @PutMapping("/updateReferral")
    public ResponseEntity<ReferralBean> updateReferral(@RequestBody ReferralBean referralBean){
        ReferralBean referralBean1 = referralService.updateReferral(referralBean);
        return new ResponseEntity<>(referralBean1, new HttpHeaders(), HttpStatus.OK);
    }
}
