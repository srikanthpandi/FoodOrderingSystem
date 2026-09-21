package com.foodordering.user;

public class User {

    private int userId;
    private String userName;
    private String mobileNumber;

    public User(int userId, String userName, String mobileNumber) {
        this.userId = userId;
        this.userName = userName;
        this.mobileNumber = mobileNumber;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "User ID: " + userId
                + ", Name: " + userName
                + ", Mobile: " + mobileNumber;
    }
}