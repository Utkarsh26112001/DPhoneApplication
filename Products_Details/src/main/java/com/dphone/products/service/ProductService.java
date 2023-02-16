package com.dphone.products.service;

import com.dphone.products.bean.ProductBean;

import java.util.List;

public interface ProductService {
    List<ProductBean> getAllProduct();
    ProductBean saveProduct(ProductBean productBean);
}
