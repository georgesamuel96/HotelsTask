package com.example.georgesamuel.dubaihotels.usecases;


import com.example.georgesamuel.dubaihotels.entities.HotelsDetailsModel;
import com.example.georgesamuel.dubaihotels.usecases.hotelsrepository.HotelsRepository;

import io.reactivex.Observable;


public class HotelsUseCase {

  private  HotelsRepository hotelsRepository;

    public HotelsUseCase() {
        hotelsRepository=new HotelsRepository();

    }

    public Observable<HotelsDetailsModel> getHotelsDetails(){
       return hotelsRepository.getHotelsDetails();
    }
}
