package com.example.georgesamuel.dubaihotels.usecases.network;

import com.example.georgesamuel.dubaihotels.entities.HotelsDetailsModel;


import retrofit2.http.GET;
import io.reactivex.Observable;

public interface HotelsAPI {

    @GET("hotels")
    Observable<HotelsDetailsModel>  getHotelsDetails ();

}
