package com.dphone.customer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long customerId;
    private String username;
    private String customerFirstName;
    private String customerLastName;
    @Column(length = 10)
    private String customerMobileNumber;
    @Column(unique = true)
    private String customerEmail;
    private String customerAddress;


}
