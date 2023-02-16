package com.dphone.products.service;

import com.dphone.products.bean.ProductBean;
import com.dphone.products.dao.ProductDao;
import com.dphone.products.entity.ProductEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

    @Autowired
    private final ProductDao productDao;


    @Override
    public List<ProductBean> getAllProduct() {
        List<ProductEntity> list = productDao.findAll();
        List<ProductBean>  beanList = new ArrayList<>();

        for(ProductEntity productEntity : list){
            ProductBean productBean = convertToBean(productEntity);

            beanList.add(productBean);
        }
        return beanList;
    }

    @Override
    public ProductBean saveProduct(ProductBean productBean) {
        ProductEntity entity =  convertToEntity(productBean);
        // from object to object copying
        boolean exists = productDao.existsById(entity.getProductId());
        if(!exists){

            productDao.save(entity);
        }
        else {
            throw new IllegalStateException("product with Id "+entity.getProductId()+" already exists");
        }
        ProductBean newReferralBean = convertToBean(entity);
        return newReferralBean;
    }

    public ProductEntity convertToEntity(ProductBean productBean){
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(productBean,productEntity);
        return productEntity;
    }

    public ProductBean convertToBean(ProductEntity productEntity){
        ProductBean productBean = new ProductBean();
        BeanUtils.copyProperties(productEntity,productBean);
        return productBean;
    }
}
