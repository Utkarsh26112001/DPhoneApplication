package com.dphone.customer.service;

import com.dphone.customer.bean.CustomerBean;
import com.dphone.customer.dao.CustomerDao;
import com.dphone.customer.entity.CustomerEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private final CustomerDao customerDao;

    @Override
    public List<CustomerBean> getAllReferral() {
        List<CustomerEntity> list = customerDao.findAll();
        List<CustomerBean>  beanList = new ArrayList<>();

        for(CustomerEntity customerEntity : list){
            CustomerBean customerBean = convertToBean(customerEntity);

            beanList.add(customerBean);
        }
        return beanList;
    }

    @Override
    public CustomerBean saveReferral(CustomerBean customerBean) {
        CustomerEntity entity =  convertToEntity(customerBean);
        // from object to object copying
        boolean exists = customerDao.existsById(entity.getCustomerId());

        if(!exists){
            customerDao.save(entity);
        }
        else {
            throw new IllegalStateException("customer with Id "+entity.getUsername()+" already exists");
        }
        return  convertToBean(entity);
    }


    public CustomerEntity convertToEntity(CustomerBean customerBean){
        CustomerEntity customerEntity = new CustomerEntity();
        BeanUtils.copyProperties(customerBean,customerEntity);
        return customerEntity;
    }

    public CustomerBean convertToBean(CustomerEntity customerEntity){
        CustomerBean customerBean = new CustomerBean();
        BeanUtils.copyProperties(customerEntity,customerBean);
        return customerBean;
    }
}
