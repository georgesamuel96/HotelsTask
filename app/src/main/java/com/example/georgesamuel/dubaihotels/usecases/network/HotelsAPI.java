package com.example.georgesamuel.dubaihotels.usecases.network;

import com.example.georgesamuel.dubaihotels.entities.HotelsResponse;


import retrofit2.http.GET;
import io.reactivex.Observable;

public interface HotelsAPI {

    @GET("hotels")
    Observable<HotelsResponse>  getHotelsDetails ();

}
