package com.dphone.user.controller;


import com.dphone.user.bean.ProductBean;
import com.dphone.user.bean.ReferralBean;
import com.dphone.user.fiegn.ProductFigenInterface;
import com.dphone.user.fiegn.ReferralFigenInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1/auth/user/product")
public class UserProductController {

    String url = "http://localhost:9191/api/v1/referral";
    @Autowired
    ProductFigenInterface productFigenInterface;
    ReferralFigenInterface referralFigenInterface;

    @CrossOrigin
    @GetMapping("/home")
    public String test(){
        return "hello";
    }

    @CrossOrigin
    @PostMapping("/buyProduct")
    public String addProduct(@RequestBody ProductBean productBean){

        ResponseEntity<ProductBean> newProductBean =  productFigenInterface.addProduct(productBean);

       if(productBean.getReferralCode()!=null){
           ReferralBean referralBean = getReferral(productBean.getReferralCode());
           updatePoints(1000,referralBean.getEmail());
       }

        System.out.println(productBean);

        System.out.println(newProductBean);
        return "product brought successfully";

    }


    public ReferralBean getReferral(String referralCode){
        RestTemplate restTemplate = new RestTemplate();
        ReferralBean referralBean = restTemplate.getForObject(url + "/searchBy/" + referralCode,ReferralBean.class);
//        r.setPoints(r.getPoints()+ 1000);
        return referralBean;
    }

    public void updatePoints(int points , String email){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject(url + "/updateRefByEmail/" +points +"/"+email,ReferralBean.class);
    }


}
