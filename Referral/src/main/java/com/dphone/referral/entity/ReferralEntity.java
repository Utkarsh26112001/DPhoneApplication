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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long referralId;
    private String referralFirstName;
    private String referralLastName;
    @Column(length = 10)
    private String mobileNumber;
    private String referralEmail;
    @Column(unique = true)
    private Long userId;
    private Date dateOfReferral;
    private int points;
    private boolean status=false;
}
