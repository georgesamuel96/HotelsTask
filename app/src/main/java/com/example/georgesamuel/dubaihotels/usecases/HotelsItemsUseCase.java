package com.example.georgesamuel.dubaihotels.usecases;

import androidx.lifecycle.MutableLiveData;

import com.example.georgesamuel.dubaihotels.entities.HotelsDetailsModel;
import com.example.georgesamuel.dubaihotels.usecases.hotelsrepository.HotelsRepository;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class HotelsItemsUseCase {

  private  HotelsRepository hotelsRepository;

    public HotelsItemsUseCase() {
        hotelsRepository=new HotelsRepository();

    }

    public Observable<List<HotelsDetailsModel>> getHotelsDetails(){
       return hotelsRepository.getHotelsDetails();
    }
}
