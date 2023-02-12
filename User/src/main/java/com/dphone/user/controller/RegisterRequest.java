package com.dphone.user.controller;

import jakarta.annotation.sql.DataSourceDefinition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String userName;
    private String userFirstName;
    private String userLastName;

    private  String userEmail;
    private String userMobile;
    private String userPassword;
    private String userAddress;

}
