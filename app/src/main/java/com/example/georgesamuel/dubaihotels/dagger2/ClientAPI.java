package com.example.georgesamuel.dubaihotels.dagger2;

import com.example.georgesamuel.dubaihotels.model.hotel.HotelsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ClientAPI {

    @GET("/hotels")
    Call<HotelsResponse> getHotels();
}
