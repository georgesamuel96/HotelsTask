
package com.example.georgesamuel.dubaihotels.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Hotel implements Serializable {

    @SerializedName("hotelId")
    @Expose
    private Integer hotelId;
    @SerializedName("image")
    @Expose
    private List<Image> image = null;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("summary")
    @Expose
    private Summary summary;

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
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
