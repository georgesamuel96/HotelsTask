package com.example.georgesamuel.dubaihotels.model.alertDialog;

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
