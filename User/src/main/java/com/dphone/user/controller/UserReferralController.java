package com.dphone.user.controller;
import com.dphone.user.bean.ReferralBean;
import com.dphone.user.fiegn.ReferralFigenInterface;
import com.dphone.user.util.ReferralSearchByName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/api/v1/auth/user/ref")
public class UserReferralController {

    @Autowired
    ReferralFigenInterface referralFigenInterface;
    @CrossOrigin
    @GetMapping(value = "/test")
    public String testReferralDetails(){

       String val = referralFigenInterface.test();

       return val + " from referral and user" ;

    }

    @CrossOrigin
    @PostMapping(value="/sendReferral")
    public String referralAdd(@RequestBody ReferralBean referralBean){

        ResponseEntity<ReferralBean> userReferral = referralFigenInterface.addReferral(referralBean);

        // need to call email services

        return  "save";
    }
    @CrossOrigin
    @GetMapping("/getAllByUsername/{username}")
    public List<ReferralBean> displayAllReferralOfUser(@PathVariable("username")String username){

        return referralFigenInterface.displayAllReferralOfUser(username);
    }

    @CrossOrigin
    @GetMapping("/email/{email}")
    public ResponseEntity<ReferralBean> searchByEmail(@PathVariable("email") String email){

        return referralFigenInterface.searchByEmail(email);
    }
    @CrossOrigin
    @GetMapping("/name/searchByName")
    public ResponseEntity<List<ReferralBean>> searchByReferralFirstName(@RequestBody ReferralSearchByName obj){
        return referralFigenInterface.searchByReferralFirstName(obj);
    }
    @CrossOrigin
    @GetMapping("/phone/{mobile}")
    public ResponseEntity<ReferralBean> searchByMobile(@PathVariable("mobile") String mobile){

        return referralFigenInterface.searchByMobile(mobile);
    }

    @CrossOrigin
    @PutMapping("/updateReferral")
    public ResponseEntity<ReferralBean> updateReferral(@RequestBody ReferralBean referralBean){
        return referralFigenInterface.updateReferral(referralBean);
    }

    @CrossOrigin
    @GetMapping("/searchBy/{referralCode}")
    public ResponseEntity<ReferralBean> findByReferralCode(@PathVariable("referralCode") String referralCode){

        ResponseEntity<ReferralBean> reponseEntity = referralFigenInterface.findByReferralCode(referralCode);

        reponseEntity.getBody();



        return reponseEntity;
    }

}
