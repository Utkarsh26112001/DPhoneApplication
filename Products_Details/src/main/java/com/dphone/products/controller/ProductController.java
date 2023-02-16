package com.dphone.products.controller;

import com.dphone.products.bean.ProductBean;
import com.dphone.products.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/home")
    public String test(){
        return "hello";
    }

    @GetMapping("/getAllProducts")
    public List<ProductBean> diaplayAll(){
        return productService.getAllProduct();
    }

    @PostMapping("/saveProduct")
    public ResponseEntity<ProductBean> addProduct(@RequestBody ProductBean productBean){
        ProductBean productBean1 = productService.saveProduct(productBean);
        return new ResponseEntity<>(productBean1, new HttpHeaders(), HttpStatus.OK);
    }
}
