package com.dphone.user.bean;

public class UserBean {

    private String userName;
    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private String userMobile;
    private String userPassword;
    private String userAddress;


    public UserBean() {

    }



    public String getUserId() {
        return userName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserAddress() {
        return userAddress;
    }



    public UserBean(String userName, String userFirstName, String userLastName, String userEmail, String userMobile, String userPassword, String userAddress) {
        this.userName = userName;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userMobile = userMobile;
        this.userPassword = userPassword;
        this.userAddress = userAddress;

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserId(String userName) {
        this.userName = userName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }


}
