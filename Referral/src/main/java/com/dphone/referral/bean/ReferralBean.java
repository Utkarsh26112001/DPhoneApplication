package com.dphone.referral.bean;


import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReferralBean {
    private long referralId;
    private String referralFirstName;
    private String referralLastName;
    private String referralMobileNumber;
    private String referralEmail;
    private long userId;
    private Date dateOfReferral;
    private int points;
    private boolean status;

}
