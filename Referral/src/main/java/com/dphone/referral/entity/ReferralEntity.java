package com.dphone.referral.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Referral")
public class ReferralEntity {
    @Id
    @GeneratedValue
    public int referralId;
    private String username;
    private String referralFirstName;
    private String referralLastName;
    @Column(length = 10)
    private String mobileNumber;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String referralCode;
    private Date dateOfReferral;
    private int points;
    private boolean status=false;
}
