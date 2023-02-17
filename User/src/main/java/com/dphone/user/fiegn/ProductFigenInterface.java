package com.dphone.user.fiegn;

import com.dphone.user.bean.ProductBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value="ProductsDetailsApplication",url = "http://localhost:9191/api/product")
public interface ProductFigenInterface {

    @GetMapping("/home")
    public String test();
    @PostMapping("/saveProduct")
    public ResponseEntity<ProductBean> addProduct(@RequestBody ProductBean productBean);

}
