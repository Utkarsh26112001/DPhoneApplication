package com.dphone.user.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
