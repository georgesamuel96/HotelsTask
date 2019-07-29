package com.example.georgesamuel.dubaihotels.presentation.features.items;

import android.annotation.SuppressLint;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.georgesamuel.dubaihotels.entities.HotelsDetailsModel;
import com.example.georgesamuel.dubaihotels.usecases.HotelsItemsUseCase;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class ListItemsViewModel extends ViewModel {


    public MutableLiveData<List<HotelsDetailsModel>> result;
    private MutableLiveData<Boolean> retreiving;
    private HotelsItemsUseCase useCase;
    private CompositeDisposable compositeDisposable;

    public ListItemsViewModel() {
        result=new MutableLiveData<>();
        retreiving=new MutableLiveData<>();
        useCase=new HotelsItemsUseCase();
        compositeDisposable=new CompositeDisposable();
    }

    public void getDetails(){

       Observable<List<HotelsDetailsModel>> call=useCase.getHotelsDetails();
       Disposable disposable= call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver <List<HotelsDetailsModel>>() {
                    @Override
                    public void onNext(List<HotelsDetailsModel> hotelsDetailsList) {
                       result.postValue(hotelsDetailsList);
                       retreiving.postValue(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        retreiving.postValue(false);
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
