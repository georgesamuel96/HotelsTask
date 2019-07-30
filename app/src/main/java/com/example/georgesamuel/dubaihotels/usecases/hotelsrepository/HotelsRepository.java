package com.example.georgesamuel.dubaihotels.usecases.hotelsrepository;

import com.example.georgesamuel.dubaihotels.entities.HotelsResponse;
import com.example.georgesamuel.dubaihotels.presentation.features.HotelsApplication;
import com.example.georgesamuel.dubaihotels.usecases.network.ApiClient;
import com.example.georgesamuel.dubaihotels.usecases.network.HotelsAPI;

import io.reactivex.Observable;

public class HotelsRepository {

    private HotelsAPI hotelsAPI;

    public HotelsRepository() {
       hotelsAPI= ApiClient.getClient(HotelsApplication.getAppContext()).create(HotelsAPI.class);
    }

    public Observable<HotelsResponse> getHotelsDetails(){
        return hotelsAPI.getHotelsDetails();
    }
}
