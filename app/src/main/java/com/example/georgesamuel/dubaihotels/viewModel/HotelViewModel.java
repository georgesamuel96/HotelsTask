package com.example.georgesamuel.dubaihotels.viewModel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.georgesamuel.dubaihotels.model.Hotel;
import com.example.georgesamuel.dubaihotels.model.HotelsResponse;
import com.example.georgesamuel.dubaihotels.remote.ClientAPI;
import com.example.georgesamuel.dubaihotels.remote.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HotelViewModel extends AndroidViewModel {

    private MutableLiveData<List<Hotel>> hotelsList = new MutableLiveData<>();
    private ClientAPI clientAPI;
    private final String TAG = "HotelViewModel";

    public HotelViewModel(@NonNull Application application) {
        super(application);

        clientAPI = RetrofitClient.getInstance();
    }

    public LiveData<List<Hotel>> getHotels(){

        clientAPI.getHotels().enqueue(new Callback<HotelsResponse>() {
            @Override
            public void onResponse(Call<HotelsResponse> call, Response<HotelsResponse> response) {

                HotelsResponse hotelsResponse = response.body();
                if(hotelsResponse != null) {
                    hotelsList.postValue(hotelsResponse.getHotel());
                }
            }

            @Override
            public void onFailure(Call<HotelsResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: HotelViewModel" + t.getMessage());
            }
        });

        return hotelsList;
    }
}
