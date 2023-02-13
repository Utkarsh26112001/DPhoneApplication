package com.dphone.customer.bean;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerBean {
    private long customerId;
    private String customerFirstName;
    private String customerLastName;
    private String customerMobileNumber;
    private String customerEmail;
    private String customerLoginId;
    private String customerPassword;

}
