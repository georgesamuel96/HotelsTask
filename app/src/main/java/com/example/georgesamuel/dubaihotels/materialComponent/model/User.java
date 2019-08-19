package com.example.georgesamuel.dubaihotels.materialComponent.model;

public class User {

    int userImage;
    String userName;

    public User(int userImage, String userName){
        this.userImage = userImage;
        this.userName = userName;
    }
    public int getUserImage() {
        return userImage;
    }

    public String getUserName() {
        return userName;
    }
}
