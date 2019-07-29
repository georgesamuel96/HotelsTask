
package com.example.georgesamuel.dubaihotels.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class HotelsDetailsModel implements Serializable {

    @SerializedName("hotel")
    @Expose
    private List<Hotel> hotel = null;

    public List<Hotel> getHotel() {
        return hotel;
    }

    public void setHotel(List<Hotel> hotel) {
        this.hotel = hotel;
    }

}
