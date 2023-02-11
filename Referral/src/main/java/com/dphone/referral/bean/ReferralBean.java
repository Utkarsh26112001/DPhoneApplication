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
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String email;
    private long userId;
    private Date dateOfReferral;
    private int points;
    private boolean status;

}
