package com.dphone.user.controller;


import com.dphone.user.bean.ReferralBean;
import com.dphone.user.fiegn.ReferralFigenInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Ref;
import java.util.List;

@RestController

@RequestMapping("/api/v1/auth/user/ref")
public class UserReferralController {

    @Autowired
    ReferralFigenInterface referralFigenInterface;
    @GetMapping(value = "/test")
    public String testReferralDetails(){

       String val = referralFigenInterface.test();

       return val + " from referral and user" ;

    }

    @PostMapping(value="/sendReferral")
    public String referralAdd(@RequestBody ReferralBean referralBean){

        ResponseEntity<ReferralBean> userReferral = referralFigenInterface.addReferral(referralBean);

        return  "save";
    }

    @GetMapping(value="/totalReferrals")

    public List<ReferralBean> displayReferral(){

        return referralFigenInterface.diaplayAll();
    }

}
