package com.user.model;

public class User {
    
    private int userId; 
    private String userName;
    private String emailId;
    private String passWord;
    private int age;

    // Default constructor
    public User() {
        super();
    }

    // Parameterized constructor
    public User(int userId, String userName, String emailId, String passWord, int age) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.emailId = emailId;
        this.passWord = passWord;
        this.age = age;
    }

    // Getter and setter methods
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Overridden toString() method
    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", emailId=" + emailId + ", passWord=" + passWord + ", age=" + age + "]";
    }
}
