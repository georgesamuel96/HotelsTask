package com.example.georgesamuel.dubaihotels.usecases.hotelsrepository;

import com.example.georgesamuel.dubaihotels.entities.HotelsResponse;
import com.example.georgesamuel.dubaihotels.presentation.features.HotelsApplication;
import com.example.georgesamuel.dubaihotels.usecases.network.HotelsAPI;

import javax.inject.Inject;

import io.reactivex.Observable;

public class HotelsRepository {

    @Inject
    HotelsAPI hotelsAPI;

    public HotelsRepository() {

      HotelsApplication.getNetComponent().inject(this);
    }

    public Observable<HotelsResponse> getHotelsDetails(){
        return hotelsAPI.getHotelsDetails();
    }
}
