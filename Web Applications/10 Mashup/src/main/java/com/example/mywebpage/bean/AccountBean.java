package com.example.mywebpage.bean;

public class AccountBean {

    private String firstName;
    private String lastName;
    private String userID;
    private String password;

    public AccountBean(String firstName, String lastName, String userID, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userID = userID;
        this.password = password;
    }

    public AccountBean(String userID, String password) {
        this.userID = userID;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }
}
