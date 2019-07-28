package com.example.georgesamuel.dubaihotels.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Hotel {

    @SerializedName("hotelId")
    private int hotelId;
    @SerializedName("image")
    private List<Image> image = null;
    @SerializedName("location")
    private Location location;
    @SerializedName("summary")
    private Summary summary;

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public List<Image> getImage() {
        return image;
    }

    public void setImage(List<Image> image) {
        this.image = image;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

}
