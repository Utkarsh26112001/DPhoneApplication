package com.dphone.products.bean;

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
    private Long productId;
    private Long price;
    private String referralCode;
    private Integer quantity;
    private Date buyingDate;

}
