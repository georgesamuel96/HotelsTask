package com.example.georgesamuel.dubaihotels.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HotelsResponse {

    private String message;
    @SerializedName("hotel")
    private List<Hotel> hotel = null;

    public List<Hotel> getHotel() {
        return hotel;
    }

    public void setHotel(List<Hotel> hotel) {
        this.hotel = hotel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
