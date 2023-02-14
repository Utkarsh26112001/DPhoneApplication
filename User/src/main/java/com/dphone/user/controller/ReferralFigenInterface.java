package com.dphone.user.controller;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value="ReferralApplication",url = "http://localhost:9191/api/v1/referral")
 interface ReferralFigenInterface {

    @GetMapping(value="/home")
    public String test();

}
