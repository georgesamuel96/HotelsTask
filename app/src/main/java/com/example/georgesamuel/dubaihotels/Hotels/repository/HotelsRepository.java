package com.example.georgesamuel.dubaihotels.Hotels.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.georgesamuel.dubaihotels.Hotels.remote.ClientAPI;
import com.example.georgesamuel.dubaihotels.Hotels.model.Hotel;
import com.example.georgesamuel.dubaihotels.Hotels.model.HotelsResponse;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HotelsRepository {

    private final MutableLiveData<List<Hotel>> listHotels;
    private final MutableLiveData<String> errorMessage;
    private ClientAPI clientAPI;
    private String error;
    private static final String TAG = HotelsRepository.class.getSimpleName();

    public HotelsRepository(ClientAPI clientAPI) {
        this.clientAPI = clientAPI;
        listHotels = new MutableLiveData<>();
        errorMessage = new MutableLiveData<>();
    }

    public LiveData<List<Hotel>> getHotels() {

        clientAPI.getHotels().enqueue(new Callback<HotelsResponse>() {
            @Override
            public void onResponse(Call<HotelsResponse> call, Response<HotelsResponse> response) {
                if (response.isSuccessful() && response != null) {
                    Log.d(TAG, "getHotels");
                    HotelsResponse hotelsResponse = response.body();
                    listHotels.setValue(hotelsResponse.getHotel());
                } else {
                    switch (response.code()) {
                        case 404:
                          //  error = context.getString(R.string.not_found);
                            break;
                        case 500:
                          //  error = context.getString(R.string.not_found);
                            break;
                        default:
                           // error = context.getString(R.string.unknown_error);
                            break;
                    }
                    showError();
                }
            }

            @Override
            public void onFailure(Call<HotelsResponse> call, Throwable t) {
                if (t instanceof IOException) {
                   // error = context.getString(R.string.no_internet_connection);
                    showError();
                }
            }
        });

        return listHotels;
    }

    public LiveData<String> showError() {
        errorMessage.setValue(error);
        return errorMessage;
    }
}
