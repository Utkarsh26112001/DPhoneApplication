package com.dphone.user.fiegn;


import com.dphone.user.bean.ReferralBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value="ReferralApplication",url = "http://localhost:9191/api/v1/referral")
public
interface ReferralFigenInterface {

    @GetMapping(value="/home")
    public String test();

    @PostMapping(value="/saveReferral")
    public ResponseEntity<ReferralBean> addReferral(@RequestBody ReferralBean referralBean);

    @GetMapping("/referrals/{username}")
    public ResponseEntity<ReferralBean> searchById(@PathVariable("username")  String username);

    @GetMapping("/getAllReferral")
    public List<ReferralBean> diaplayAll();

}
