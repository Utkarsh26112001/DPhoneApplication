package com.dphone.user.bean;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class ProductBean {
    private String productName;
    @Id
    @GeneratedValue
    private Long productId;
    private Long price;
    private String referralCode;
    private Integer quantity;
    private Date buyingDate;

}