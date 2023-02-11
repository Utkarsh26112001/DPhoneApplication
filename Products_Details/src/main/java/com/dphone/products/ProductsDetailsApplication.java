package com.dphone.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductsDetailsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductsDetailsApplication.class,args);
        System.out.println("Hello world!");
    }
}