package com.dphone.referral.bean;


import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReferralBean {
    private long ReferralId;
    private String FirstName;
    private String LastName;
    private String MobileNumber;
    private String Email;
    private long UserId;
    private Date DateOfReferral;
    private int Points;
    private boolean Status;

}
