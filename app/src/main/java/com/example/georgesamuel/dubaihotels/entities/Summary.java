
package com.example.georgesamuel.dubaihotels.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Summary implements Serializable {

    @SerializedName("highRate")
    @Expose
    private Double highRate;
    @SerializedName("hotelName")
    @Expose
    private String hotelName;
    @SerializedName("lowRate")
    @Expose
    private Double lowRate;

    public Double getHighRate() {
        return highRate;
    }

    public void setHighRate(Double highRate) {
        this.highRate = highRate;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Double getLowRate() {
        return lowRate;
    }

    public void setLowRate(Double lowRate) {
        this.lowRate = lowRate;
    }

}
