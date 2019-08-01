package com.example.georgesamuel.dubaihotels.presentation.features.hotels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.georgesamuel.dubaihotels.entities.HotelsResponse;
import com.example.georgesamuel.dubaihotels.usecases.HotelsUseCase;


import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class HotelViewModel extends ViewModel {

   public MutableLiveData<HotelsResponse> hotelsDetailsLiveData;
    MutableLiveData<Boolean> isLoadingLiveData;
    MutableLiveData<Boolean> hasErrorLiveData;
    private HotelsUseCase hotelsUseCase;
    private CompositeDisposable compositeDisposable;

    public HotelViewModel() {
        hotelsDetailsLiveData =new MutableLiveData<>();
        isLoadingLiveData =new MutableLiveData<>();
        hasErrorLiveData =new MutableLiveData<>();
        hasErrorLiveData.setValue(false);
        hotelsUseCase =new HotelsUseCase();
        compositeDisposable=new CompositeDisposable();
        getDetails();
    }

      private void getDetails(){
       isLoadingLiveData.setValue(true);
       Observable<HotelsResponse> call= hotelsUseCase.getHotelsDetails();
       Disposable disposable= call
                .subscribeWith(new DisposableObserver <HotelsResponse>() {
                    @Override
                    public void onNext(HotelsResponse hotelsDetailsList) {
                       hotelsDetailsLiveData.postValue(hotelsDetailsList);
                    }

                    @Override
                    public void onError(Throwable e) {
                        hasErrorLiveData.setValue(true);
                    }

                    @Override
                    public void onComplete() {
                        isLoadingLiveData.postValue(false);
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
