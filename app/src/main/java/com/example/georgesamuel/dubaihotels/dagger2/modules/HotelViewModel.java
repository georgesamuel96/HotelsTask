package com.example.georgesamuel.dubaihotels.dagger2.modules;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.georgesamuel.dubaihotels.dagger2.components.HotelsRepoComponent;
import com.example.georgesamuel.dubaihotels.dagger2.HotelsRepository;
import com.example.georgesamuel.dubaihotels.model.hotel.Hotel;

import java.util.List;

import javax.inject.Inject;

public class HotelViewModel extends ViewModel {


    private LiveData<List<Hotel>> hotelsList;
    private final LiveData<String> errorMessage;
    @Inject
    HotelsRepository hotelsRepository;

    public HotelViewModel() {
        HotelsRepoComponent.Intializer.buildComponent().inject(this);
        hotelsList = hotelsRepository.getHotels();
        errorMessage = hotelsRepository.showError();
    }

    public LiveData<List<Hotel>> getHotels() {
        return hotelsList;
    }

    /*
        Using this method when error occurred while getting data from server
     */
    public LiveData<String> showError() {
        return errorMessage;
    }

    /*
        Using this method when user want to refresh hotel list
     */
    public LiveData<List<Hotel>> updateHotels() {
        hotelsList = hotelsRepository.getHotels();
        return hotelsList;
    }
}
