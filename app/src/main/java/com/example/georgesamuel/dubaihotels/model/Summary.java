package com.example.georgesamuel.dubaihotels.model;

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

    public void setHighRate(double highRate) {
        this.highRate = highRate;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public double getLowRate() {
        return lowRate;
    }

    public void setLowRate(double lowRate) {
        this.lowRate = lowRate;
    }

}
