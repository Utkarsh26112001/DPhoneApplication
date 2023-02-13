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
    private long referralId;
    private String referralFirstName;
    private String referralLastName;
    private String referralMobileNumber;
    private String email;
    private long userId;
    private Date dateOfReferral;
    private int points;
    private boolean status;

}
