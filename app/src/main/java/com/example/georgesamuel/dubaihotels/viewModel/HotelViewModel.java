package com.example.georgesamuel.dubaihotels.viewModel;

import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.georgesamuel.dubaihotels.R;
import com.example.georgesamuel.dubaihotels.model.Hotel;
import com.example.georgesamuel.dubaihotels.model.HotelsResponse;
import com.example.georgesamuel.dubaihotels.remote.ClientAPI;
import com.example.georgesamuel.dubaihotels.remote.RetrofitClient;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HotelViewModel extends AndroidViewModel {

    private MutableLiveData<List<Hotel>> hotelsList = new MutableLiveData<>();
    private ClientAPI clientAPI;
    private static final String TAG = HotelViewModel.class.getSimpleName();

    public HotelViewModel(@NonNull Application application) {
        super(application);
        clientAPI = RetrofitClient.getInstance();
    }

    public LiveData<List<Hotel>> getHotels(View contentView){
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
                Snackbar.make(contentView, t.getMessage(), Snackbar.LENGTH_LONG)
                        .setAction(getApplication().getString(R.string.ok), view -> {}).show();
            }
        });

        return hotelsList;
    }
}
