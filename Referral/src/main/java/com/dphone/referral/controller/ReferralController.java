package com.dphone.referral.controller;


import com.dphone.referral.bean.ReferralBean;
import com.dphone.referral.service.ReferralServiceImpl;
import com.dphone.referral.util.ReferralSearchByName;
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

    @CrossOrigin
    @GetMapping("/getAllReferral")
    public List<ReferralBean> displayAll(){
        return referralService.getAllReferral();

    }

    @GetMapping("/getAllByUsername/{username}")
    public List<ReferralBean> displayAllReferralOfUser(@PathVariable("username")String username){

        return referralService.findAllByUserName(username);
    }


    @GetMapping("/email/{email}")
    public ResponseEntity<ReferralBean> searchByEmail(@PathVariable("email") String email){
        ReferralBean referralBean = (ReferralBean) referralService.searchReferralByEmail(email);
        return new ResponseEntity<>(referralBean, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/name/searchByName")
    public ResponseEntity<List<ReferralBean>> searchByReferralFirstName(@RequestBody ReferralSearchByName obj){
        List<ReferralBean> referralEntity =  referralService.searchReferralByFirstName(obj.getReferralFirstName(), obj.getUsername());
        return new ResponseEntity<>(referralEntity, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/phone/{mobile}")
    public ResponseEntity<ReferralBean> searchByMobile(@PathVariable("mobile") String mobile){
        ReferralBean referralBean = (ReferralBean) referralService.searchReferralByMobile(mobile);
        return new ResponseEntity<>(referralBean, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/saveReferral")
    public ResponseEntity<ReferralBean> addReferral(@RequestBody ReferralBean referralBean){
        ReferralBean referralBean1 = referralService.saveReferral(referralBean);
        return new ResponseEntity<>(referralBean1, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteReferral/{email}")
    public ResponseEntity<ReferralBean> deleteReferral(@PathVariable("email") String email){
            ReferralBean referralBean = referralService.deleteReferral(email);
        return new ResponseEntity<>(referralBean, new HttpHeaders(), HttpStatus.OK);
    }
    @PutMapping("/updateReferral")
    public ResponseEntity<ReferralBean> updateReferral(@RequestBody ReferralBean referralBean){
        ReferralBean referralBean1 = referralService.updateReferral(referralBean);
        return new ResponseEntity<>(referralBean1, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/searchBy/{referralCode}")
    public ReferralBean findByReferralCode(@PathVariable("referralCode") String referralCode){
        ReferralBean referralBean = referralService.findByReferralCode(referralCode);
        return referralBean;
    }

    @GetMapping("/updateRefByEmail/{points}/{email}")
    public ReferralBean updateReferralByEmail(@PathVariable ("points") int points , @PathVariable ("email") String email){
        ReferralBean referralBean = referralService.updateReferralByEmail(points,email);
        return referralBean;
    }
}
