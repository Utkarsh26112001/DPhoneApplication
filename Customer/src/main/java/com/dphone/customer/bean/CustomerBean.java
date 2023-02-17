package com.dphone.customer.bean;

//import lombok.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerBean {
    private Long customerId;
    private String username;
    private String customerFirstName;
    private String customerLastName;
    private String customerMobileNumber;
    private String customerEmail;
    private String customerAddress;

}
