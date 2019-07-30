package com.example.georgesamuel.dubaihotels.presentation.features.items;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.georgesamuel.dubaihotels.entities.HotelsDetailsModel;
import com.example.georgesamuel.dubaihotels.usecases.HotelsItemsUseCase;


import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class HotelViewModel extends ViewModel {


    MutableLiveData<HotelsDetailsModel> result;
    MutableLiveData<Boolean> retrieving;
    private HotelsItemsUseCase useCase;
    private CompositeDisposable compositeDisposable;

    public HotelViewModel() {
        result=new MutableLiveData<>();
        retrieving =new MutableLiveData<>();
        useCase=new HotelsItemsUseCase();
        compositeDisposable=new CompositeDisposable();
    }

        void getDetails(){

        retrieving.setValue(true);
       Observable<HotelsDetailsModel> call=useCase.getHotelsDetails();
       Disposable disposable= call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver <HotelsDetailsModel>() {
                    @Override
                    public void onNext(HotelsDetailsModel hotelsDetailsList) {
                       result.postValue(hotelsDetailsList);
                       retrieving.postValue(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        retrieving.postValue(false);
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
