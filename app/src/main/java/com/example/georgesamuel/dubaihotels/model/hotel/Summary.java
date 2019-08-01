package com.example.georgesamuel.dubaihotels.model.hotel;

import com.google.gson.annotations.SerializedName;

public class Summary {

    @SerializedName("highRate")
    private double highRate;
    @SerializedName("hotelName")
    private String hotelName;
    @SerializedName("lowRate")
    private double lowRate;

    public double getHighRate() {
        return highRate;
    }

    public String getHotelName() {
        return hotelName;
    }

    public double getLowRate() {
        return lowRate;
    }
}
