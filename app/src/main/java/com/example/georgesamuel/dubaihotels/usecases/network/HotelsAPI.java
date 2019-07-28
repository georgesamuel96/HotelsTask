package com.example.georgesamuel.dubaihotels.usecases.network;

import com.example.georgesamuel.dubaihotels.entities.HotelsDetailsModel;

import java.util.List;

import retrofit2.http.GET;
import io.reactivex.Observable;

public interface HotelsAPI {

    @GET("hotels")
    Observable<List<HotelsDetailsModel>>  getHotelsDetails ();

}
