package com.dphone.referral.controller;


import com.dphone.referral.bean.ReferralBean;
import com.dphone.referral.entity.ReferralEntity;
import com.dphone.referral.service.ReferralService;
import com.dphone.referral.service.ReferralServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/referral/v1")
public class ReferralController {

    @Autowired
    private ReferralServiceImpl referralService;
    @GetMapping("/home")
    public String test(){
        return "hello";
    }

    @GetMapping("/getAllReferral")
    public ResponseEntity<ReferralBean> diaplayAll(){
        ReferralBean referralBean = (ReferralBean) referralService.getAllReferral();
        return new ResponseEntity<>(referralBean, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/getById")
    public ResponseEntity<ReferralEntity> searchById(@PathVariable("referralId") Long referralId){
        ReferralEntity referralEntity = (ReferralEntity) referralService.searchReferralById(referralId);
        return new ResponseEntity<>(referralEntity, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/getByEmail")
    public ResponseEntity<ReferralEntity> searchByEmail(@PathVariable("referralEmail") String referralEmail){
        ReferralEntity referralEntity = (ReferralEntity) referralService.searchReferralByEmail(referralEmail);
        return new ResponseEntity<>(referralEntity, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/getByFirstName")
    public ResponseEntity<ReferralEntity> searchByFname(@PathVariable("referralFname") String referralFname){
        ReferralEntity referralEntity = (ReferralEntity) referralService.searchReferralByFirstName(referralFname);
        return new ResponseEntity<>(referralEntity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/saveReferral")
    public ResponseEntity<ReferralBean> addReferral(@RequestBody ReferralBean referralBean){
        ReferralBean referralBean1 = referralService.saveReferral(referralBean);
        return new ResponseEntity<>(referralBean1, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteReferral")
    public ResponseEntity<ReferralBean> deleteReferral(@PathVariable("referralId") Long referralId){
        ReferralBean referralBean = referralService.deleteReferral(referralId);
        return new ResponseEntity<>(referralBean, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("/updateReferral")
    public ResponseEntity<ReferralBean> updateReferral(@RequestBody ReferralBean referralBean){
        ReferralBean referralBean1 = referralService.updateReferral(referralBean);
        return new ResponseEntity<>(referralBean1, new HttpHeaders(), HttpStatus.OK);
    }
}
