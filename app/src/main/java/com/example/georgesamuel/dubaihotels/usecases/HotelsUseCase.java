package com.example.georgesamuel.dubaihotels.usecases;


import com.example.georgesamuel.dubaihotels.entities.HotelsResponse;
import com.example.georgesamuel.dubaihotels.usecases.hotelsrepository.HotelsRepository;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class HotelsUseCase {

  private  HotelsRepository hotelsRepository;

    public HotelsUseCase() {
        hotelsRepository=new HotelsRepository();
    }

    public Observable<HotelsResponse> getHotelsDetails(){
       return hotelsRepository.getHotelsDetails().subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread());
    }
}
