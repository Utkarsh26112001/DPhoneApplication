package com.dphone.referral.bean;


import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class ReferralBean {

    private int referralId;
    private String referralCode;
    private String referralFirstName;
    private String referralLastName;
    private String mobileNumber;
    private String email;
    private String username;
    private Date dateOfReferral;
    private int points;
    private boolean status;

}
