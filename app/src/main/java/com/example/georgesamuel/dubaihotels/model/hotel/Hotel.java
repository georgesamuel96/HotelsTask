package com.example.georgesamuel.dubaihotels.model.hotel;

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

    public List<Image> getImage() {
        return image;
    }

    public Location getLocation() {
        return location;
    }

    public Summary getSummary() {
        return summary;
    }
}
