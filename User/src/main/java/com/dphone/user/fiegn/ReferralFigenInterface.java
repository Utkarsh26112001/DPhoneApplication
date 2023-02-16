package com.dphone.user.fiegn;


import com.dphone.user.bean.ReferralBean;
import com.dphone.user.util.ReferralSearchByName;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value="ReferralApplication",url = "http://localhost:9191/api/v1/referral")
public
interface ReferralFigenInterface {

    @GetMapping(value="/home")
    public String test();

    @PostMapping(value="/saveReferral")
    public ResponseEntity<ReferralBean> addReferral(@RequestBody ReferralBean referralBean);


    @GetMapping("/getAllByUsername/{username}")
    public List<ReferralBean> displayAllReferralOfUser(@PathVariable("username")String username);

    @GetMapping("/email/{email}")
    public ResponseEntity<ReferralBean> searchByEmail(@PathVariable("email") String email);

    @GetMapping("/name/searchByName")
    public ResponseEntity<List<ReferralBean>> searchByReferralFirstName(@RequestBody ReferralSearchByName obj);

    @GetMapping("/phone/{mobile}")
    public ResponseEntity<ReferralBean> searchByMobile(@PathVariable("mobile") String mobile);

    @DeleteMapping("/deleteReferral/{email}")
    public ResponseEntity<ReferralBean> deleteReferral(@PathVariable("email") String email);

    @PutMapping("/updateReferral")
    public ResponseEntity<ReferralBean> updateReferral(@RequestBody ReferralBean referralBean);

}
