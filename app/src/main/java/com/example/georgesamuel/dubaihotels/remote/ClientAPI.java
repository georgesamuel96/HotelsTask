package com.example.georgesamuel.dubaihotels.remote;

import com.example.georgesamuel.dubaihotels.model.HotelsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ClientAPI {

    @GET("/hotels")
    Call<HotelsResponse> getHotels();
}
