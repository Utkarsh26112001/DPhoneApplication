package com.dphone.products.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    private String referralCode;
    private String productName;
    private Long price;
    private Integer quantity;
    private Date buyingDate;
}
