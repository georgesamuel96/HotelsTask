package com.example.georgesamuel.dubaihotels.presentation.features.items;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.georgesamuel.dubaihotels.entities.HotelsDetailsModel;
import com.example.georgesamuel.dubaihotels.usecases.HotelsUseCase;


import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class HotelViewModel extends ViewModel {

    MutableLiveData<HotelsDetailsModel> hotelsDetailsLiveData;
    MutableLiveData<Boolean> isLoadingLiveData;
    private HotelsUseCase hotelsUseCase;
    private CompositeDisposable compositeDisposable;

    public HotelViewModel() {
        hotelsDetailsLiveData =new MutableLiveData<>();
        isLoadingLiveData =new MutableLiveData<>();
        hotelsUseCase =new HotelsUseCase();
        compositeDisposable=new CompositeDisposable();
        getDetails();
    }

        void getDetails(){

        isLoadingLiveData.setValue(true);
       Observable<HotelsDetailsModel> call= hotelsUseCase.getHotelsDetails();
       Disposable disposable= call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver <HotelsDetailsModel>() {
                    @Override
                    public void onNext(HotelsDetailsModel hotelsDetailsList) {
                       hotelsDetailsLiveData.postValue(hotelsDetailsList);
                       isLoadingLiveData.postValue(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        isLoadingLiveData.postValue(false);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
       compositeDisposable.add(disposable);

    }


    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }
}
