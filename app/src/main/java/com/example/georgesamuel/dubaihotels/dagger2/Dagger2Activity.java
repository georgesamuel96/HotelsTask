package com.example.georgesamuel.dubaihotels.dagger2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.georgesamuel.dubaihotels.R;
import com.example.georgesamuel.dubaihotels.dagger2.components.HotelVMComponent;
import com.example.georgesamuel.dubaihotels.dagger2.modules.HotelViewModel;
import com.example.georgesamuel.dubaihotels.model.hotel.Hotel;

import java.util.List;

public class Dagger2Activity extends AppCompatActivity {

    private HotelViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger2);

        HotelViewModel viewModel = ViewModelProviders.of(this).get(HotelViewModel.class);
        viewModel.getHotels().observe(this, new Observer<List<Hotel>>() {
            @Override
            public void onChanged(List<Hotel> hotels) {

            }
        });

        HotelVMComponent.Initializer.buildComponent().inject(this);
        viewModel.getHotels().observe(this, new Observer<List<Hotel>>() {
            @Override
            public void onChanged(List<Hotel> hotels) {

            }
        });
    }
}
