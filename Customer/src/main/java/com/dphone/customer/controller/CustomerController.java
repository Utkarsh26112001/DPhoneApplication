package com.dphone.customer.controller;

import com.dphone.customer.bean.CustomerBean;
import com.dphone.customer.service.CustomerServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;

    @GetMapping("/home")
    public String test(){
        return "working";
    }

    @GetMapping("/getAllCustomer")
    public List<CustomerBean> displayAll(){
        return customerService.getAllReferral();
    }

    @PostMapping("/saveCustomer")
    public ResponseEntity<CustomerBean> addReferral(@RequestBody CustomerBean customerBean){
        CustomerBean customerBean1 = customerService.saveReferral(customerBean);
        return new ResponseEntity<>(customerBean1, new HttpHeaders(), HttpStatus.OK);
    }
}
