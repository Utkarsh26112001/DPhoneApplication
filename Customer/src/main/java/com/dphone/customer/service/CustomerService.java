package com.dphone.customer.service;

import com.dphone.customer.bean.CustomerBean;

import java.util.List;

public interface CustomerService {
    List<CustomerBean> getAllReferral();
    CustomerBean saveReferral(CustomerBean customerBean);
}
