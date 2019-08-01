package com.example.georgesamuel.dubaihotels.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.georgesamuel.dubaihotels.model.hotel.Hotel;
import com.example.georgesamuel.dubaihotels.repositories.HotelsRepository;

import java.util.List;

public class HotelViewModel extends AndroidViewModel {

    private final HotelsRepository hotelsRepository;
    private LiveData<List<Hotel>> hotelsList;
    private final LiveData<String> errorMessage;

    public HotelViewModel(@NonNull Application application) {
        super(application);
        hotelsRepository = new HotelsRepository(application.getApplicationContext());
        hotelsList = hotelsRepository.getHotels();
        errorMessage = hotelsRepository.showError();
    }

    public LiveData<List<Hotel>> getHotels(){
        return hotelsList;
    }
    /*
        Using this method when error occurred while getting data from server
     */
    public LiveData<String> showError(){
        return errorMessage;
    }
    /*
        Using this method when user want to refresh hotel list
     */
    public LiveData<List<Hotel>> updateHotels(){
        hotelsList = hotelsRepository.getHotels();
        return hotelsList;
    }
}
