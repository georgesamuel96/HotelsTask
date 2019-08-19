package com.example.georgesamuel.dubaihotels.Hotels.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HotelsResponse {

    @SerializedName("hotel")
    private List<Hotel> hotel = null;

    public List<Hotel> getHotel() {
        return hotel;
    }
}
