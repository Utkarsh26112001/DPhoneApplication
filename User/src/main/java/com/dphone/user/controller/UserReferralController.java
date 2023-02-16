package com.dphone.user.controller;
import com.dphone.user.bean.ReferralBean;
import com.dphone.user.fiegn.ReferralFigenInterface;
import com.dphone.user.util.ReferralSearchByName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

        // need to call email services

        return  "save";
    }

    @GetMapping("/getAllByUsername/{username}")
    public List<ReferralBean> displayAllReferralOfUser(@PathVariable("username")String username){

        return referralFigenInterface.displayAllReferralOfUser(username);
    }


    @GetMapping("/email/{email}")
    public ResponseEntity<ReferralBean> searchByEmail(@PathVariable("email") String email){

        return referralFigenInterface.searchByEmail(email);
    }

    @GetMapping("/name/searchByName")
    public ResponseEntity<List<ReferralBean>> searchByReferralFirstName(@RequestBody ReferralSearchByName obj){
        return referralFigenInterface.searchByReferralFirstName(obj);
    }

    @GetMapping("/phone/{mobile}")
    public ResponseEntity<ReferralBean> searchByMobile(@PathVariable("mobile") String mobile){

        return referralFigenInterface.searchByMobile(mobile);
    }


    @PutMapping("/updateReferral")
    public ResponseEntity<ReferralBean> updateReferral(@RequestBody ReferralBean referralBean){
        return referralFigenInterface.updateReferral(referralBean);
    }

}
